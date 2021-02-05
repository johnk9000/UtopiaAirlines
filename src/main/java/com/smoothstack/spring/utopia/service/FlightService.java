package com.smoothstack.spring.utopia.service;

import com.smoothstack.spring.utopia.entity.Flight;
import com.smoothstack.spring.utopia.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Optional<Flight> getFlightById(Long id)
    {
        return flightRepository.findById(id);
    }

    public List<Flight> getAllFlights()
    {
        return flightRepository.findAll();
    }

    public Flight createFlight(Flight flight)
    {
        return flightRepository.save(flight);
    }
}
