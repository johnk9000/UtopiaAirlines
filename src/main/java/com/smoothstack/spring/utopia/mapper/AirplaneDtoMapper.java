package com.smoothstack.spring.utopia.mapper;

import com.smoothstack.spring.utopia.dto.AirplaneDto;
import com.smoothstack.spring.utopia.entity.Airplane;

public class AirplaneDtoMapper {

    public Airplane map(AirplaneDto airplaneDto)
    {
        Airplane airplane = new Airplane();
        airplane.setMaxCapacity(airplaneDto.getMaxCapacity());
        return airplane;
    }
}
