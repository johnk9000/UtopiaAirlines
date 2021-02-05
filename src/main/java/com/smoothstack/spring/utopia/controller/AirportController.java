package com.smoothstack.spring.utopia.controller;

import com.smoothstack.spring.utopia.dto.AirportDto;
import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.entity.Airport;
import com.smoothstack.spring.utopia.mapper.AirplaneDtoMapper;
import com.smoothstack.spring.utopia.mapper.AirportDtoMapper;
import com.smoothstack.spring.utopia.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id)
    {
        return ResponseEntity.of(airportService.getAirportById(id));
    }

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports()
    {
        List<Airport> airports = airportService.getAllAirports();
        if(airports.size() == 0)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(airports);
    }

    @PostMapping
    public ResponseEntity<Long> createAirport(@Valid @RequestBody AirportDto airportDto)
    {
        AirportDtoMapper airportDtoMapper = new AirportDtoMapper();
        Airport airport = airportDtoMapper.map(airportDto);
        Airport createdAirport = airportService.createAirport(airport);
        return ResponseEntity.status(201).body(createdAirport.getId());
    }
}
