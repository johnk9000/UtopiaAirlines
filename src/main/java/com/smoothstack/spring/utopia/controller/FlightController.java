package com.smoothstack.spring.utopia.controller;

import com.smoothstack.spring.utopia.dto.FlightDto;
import com.smoothstack.spring.utopia.entity.Flight;
import com.smoothstack.spring.utopia.mapper.FlightDtoMapper;
import com.smoothstack.spring.utopia.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

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
        FlightDtoMapper flightDtoMapper = new FlightDtoMapper();
        Flight flight = flightDtoMapper.map(flightDto);
        Flight createdFlight = flightService.createFlight(flight);
        return ResponseEntity.status(201).body(createdFlight.getId());
    }
}
