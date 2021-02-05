package com.smoothstack.spring.utopia.service;

import com.smoothstack.spring.utopia.entity.Airport;
import com.smoothstack.spring.utopia.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
