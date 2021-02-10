package com.smoothstack.spring.utopia.controller;

import com.smoothstack.spring.utopia.dto.AirportDto;
import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.entity.Airport;
import com.smoothstack.spring.utopia.mapper.AirplaneDtoMapper;
import com.smoothstack.spring.utopia.mapper.AirportDtoMapper;
import com.smoothstack.spring.utopia.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id)
    {
        return ResponseEntity.of(airportService.getAirportById(id));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Airport>> getAllAirports()
    {
        List<Airport> airports = airportService.getAllAirports();
        if(airports.size() == 0)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(airports);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Long> createAirport(@Valid @RequestBody AirportDto airportDto)
    {
        AirportDtoMapper airportDtoMapper = new AirportDtoMapper();
        Airport airport = airportDtoMapper.map(airportDto);
        Airport createdAirport = airportService.createAirport(airport);
        return ResponseEntity.status(201).body(createdAirport.getId());
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> updateAirport(@PathVariable Long id, @Valid @RequestBody AirportDto airportDto)
    {
        if (id == null)
            return ResponseEntity.badRequest().body(Map.of("message", "Airport ID is required for update"));

        AirportDtoMapper airportDtoMapper = new AirportDtoMapper();
        Airport airportToUpdate = airportDtoMapper.map(airportDto);
        airportToUpdate.setId(id);
        try{
            Airport updatedAirport = airportService.updateAirport(airportToUpdate);
            return ResponseEntity.ok(updatedAirport);
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long id)
    {
        if(airportService.airportInFlight(id))
            return ResponseEntity.status(405).body("Can't delete airport in flight");
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}
