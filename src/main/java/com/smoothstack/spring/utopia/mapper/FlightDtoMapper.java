package com.smoothstack.spring.utopia.mapper;

import com.smoothstack.spring.utopia.dto.FlightDto;
import com.smoothstack.spring.utopia.entity.Flight;
import com.smoothstack.spring.utopia.service.AirplaneService;
import com.smoothstack.spring.utopia.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;

public class FlightDtoMapper {

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirplaneService airplaneService;

    public Flight map(FlightDto flightDto)
    {
        Flight flight = new Flight();
        flight.setOrigin(airportService.getAirportById(flightDto.getOriginId()).get());
        flight.setDestination(airportService.getAirportById(flightDto.getDestinationId()).get());
        flight.setAirplane(airplaneService.getAirplaneById(flightDto.getAirplaneId()).get());
        flight.setFilledSeats(flightDto.getFilledSeats());
        return flight;
    }
}
