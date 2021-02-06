package com.smoothstack.spring.utopia.service;

import com.smoothstack.spring.utopia.entity.Airport;
import com.smoothstack.spring.utopia.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Optional<Airport> getAirportById(Long id)
    {
        return airportRepository.findById(id);
    }

    public List<Airport> getAllAirports()
    {
        return airportRepository.findAll();
    }

    public Airport createAirport(Airport airport)
    {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Airport updatedAirport)
    {
        Long airportId = updatedAirport.getId();
        if(airportId == null || airportId < 1)
            throw new IllegalArgumentException("ID cannot be less than 1 or null");

        if(getAirportById(airportId).isPresent())
            return airportRepository.save(updatedAirport);

        throw new NoSuchElementException("No airport with id " + airportId + " found");
    }

    public void deleteAirport(Long id)
    {
        Optional<Airport> airportToDelete = getAirportById(id);
        if(airportToDelete.isPresent())
            airportRepository.delete(airportToDelete.get());

    }
}
