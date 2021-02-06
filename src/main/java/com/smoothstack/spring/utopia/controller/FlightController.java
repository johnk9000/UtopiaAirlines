package com.smoothstack.spring.utopia.controller;

import com.smoothstack.spring.utopia.dto.FlightDto;
import com.smoothstack.spring.utopia.entity.Flight;
import com.smoothstack.spring.utopia.mapper.FlightDtoMapper;
import com.smoothstack.spring.utopia.service.AirplaneService;
import com.smoothstack.spring.utopia.service.AirportService;
import com.smoothstack.spring.utopia.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private AirportService airportService;

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id)
    {
        return ResponseEntity.of(flightService.getFlightById(id));
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights()
    {
        List<Flight> flights = flightService.getAllFlights();
        if(flights.size() == 0)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(flights);
    }

    @PostMapping
    public ResponseEntity<Long> createFlight(@Valid @RequestBody FlightDto flightDto)
    {
        FlightDtoMapper flightDtoMapper = new FlightDtoMapper(airportService, airplaneService);
        Flight flight = flightDtoMapper.map(flightDto);
        Flight createdFlight = flightService.createFlight(flight);
        return ResponseEntity.status(201).body(createdFlight.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable Long id, @Valid @RequestBody FlightDto flightDto)
    {
        if (id == null)
            return ResponseEntity.badRequest().body(Map.of("message", "Flight ID is required for update"));

        FlightDtoMapper flightDtoMapper = new FlightDtoMapper(airportService, airplaneService);
        Flight flightToUpdate = flightDtoMapper.map(flightDto);
        flightToUpdate.setId(id);
        try{
            Flight updatedFlight = flightService.updateFlight(flightToUpdate);
            return ResponseEntity.ok(updatedFlight);
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id)
    {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

}
