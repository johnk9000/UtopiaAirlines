package com.smoothstack.spring.utopia.controller;

import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.entity.AirplaneType;
import com.smoothstack.spring.utopia.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @RequestMapping(method = RequestMethod.GET, path = "/airplane/{planeId}")
    public Airplane getAirplaneById(@PathVariable int planeId)
    {
        return airplaneService.getAirplaneById(planeId);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/airplanes/{typeId}")
    public List<Airplane> getAirplaneByType(@PathVariable int typeId)
    {
        return airplaneService.getAirplanesByType(typeId);
    }
}
