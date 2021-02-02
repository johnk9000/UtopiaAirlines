package com.smoothstack.spring.utopia.controller;

import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.entity.AirplaneType;
import com.smoothstack.spring.utopia.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    public Airplane getAirplaneById(int planeId)
    {
        return airplaneService.getAirplaneById(planeId);
    }
}
