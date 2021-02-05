package com.smoothstack.spring.utopia.mapper;

import com.smoothstack.spring.utopia.dto.AirportDto;
import com.smoothstack.spring.utopia.entity.Airport;

public class AirportDtoMapper {

    public Airport map(AirportDto airportDto)
    {
        Airport airport = new Airport();
        airport.setCity(airportDto.getCity());
        airport.setIataId(airportDto.getIataId());
        return airport;
    }
}
