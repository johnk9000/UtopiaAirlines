package com.smoothstack.spring.utopia.service;

import com.smoothstack.spring.utopia.entity.Flight;
import com.smoothstack.spring.utopia.repository.AirplaneRepository;
import com.smoothstack.spring.utopia.entity.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private FlightService flightService;

    public Optional<Airplane> getAirplaneById(Long id)
    {
        return airplaneRepository.findById(id);
    }

    public List<Airplane> getAllAirplanes()
    {
        return airplaneRepository.findAll();
    }

    public Airplane createAirplane(Airplane airplane)
    {
        return airplaneRepository.save(airplane);
    }

    public Airplane updateAirplane(Airplane updatedAirplane)
    {
        Long airplaneId = updatedAirplane.getId();
        if(airplaneId == null || airplaneId < 1)
            throw new IllegalArgumentException("ID cannot be less than 1 or null");

        if(getAirplaneById(airplaneId).isPresent())
            return airplaneRepository.save(updatedAirplane);

        throw new NoSuchElementException("No airplane with id " + airplaneId + " found");
    }

    public void deleteAirplane(Long id)
    {
        Optional<Airplane> airplaneToDelete = getAirplaneById(id);
        if(airplaneToDelete.isPresent())
            airplaneRepository.delete(airplaneToDelete.get());
    }

    public boolean airplaneInFlight(Long id)
    {
        Optional<Airplane> optionalAirplane = getAirplaneById(id);
        if(optionalAirplane.isPresent())
        {
            Airplane airplane = optionalAirplane.get();
            for(Flight flight : flightService.getAllFlights())
            {
                if(airplane.getId() == flight.getAirplane().getId())
                    return true;
            }

        }

        return false;


    }
}
