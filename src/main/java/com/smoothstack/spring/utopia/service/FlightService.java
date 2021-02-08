package com.smoothstack.spring.utopia.service;

import com.smoothstack.spring.utopia.entity.Airport;
import com.smoothstack.spring.utopia.entity.Flight;
import com.smoothstack.spring.utopia.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        if(flight.getFilledSeats() < 0)
            throw new IllegalArgumentException();
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Flight updatedFlight)
    {
        Long flightId = updatedFlight.getId();
        if(flightId == null || flightId < 1)
            throw new IllegalArgumentException("ID cannot be less than 1 or null");

        if(getFlightById(flightId).isPresent())
            return flightRepository.save(updatedFlight);

        throw new NoSuchElementException("No flight with id " + flightId + " found");
    }

    public void deleteFlight(Long id)
    {
        Optional<Flight> flightToDelete = getFlightById(id);
        if(flightToDelete.isPresent())
            flightRepository.delete(flightToDelete.get());
    }
}
