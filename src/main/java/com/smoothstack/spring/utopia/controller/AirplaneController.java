package com.smoothstack.spring.utopia.controller;

import com.smoothstack.spring.utopia.dto.AirplaneDto;
import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.mapper.AirplaneDtoMapper;
import com.smoothstack.spring.utopia.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping({"/{id}"})
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable Long id)
    {
        return ResponseEntity.of(airplaneService.getAirplaneById(id));
    }

    @GetMapping
    public ResponseEntity<List<Airplane>> getAllAirplanes()
    {
        List<Airplane> planes = airplaneService.getAllAirplanes();
        if(planes.size() == 0)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(planes);
    }

    @PostMapping
    public ResponseEntity<Long> createAirplane(@Valid @RequestBody AirplaneDto airplaneDto)
    {
        AirplaneDtoMapper airplaneDtoMapper= new AirplaneDtoMapper();
        Airplane airplane = airplaneDtoMapper.map(airplaneDto);
        Airplane createdAirplane = airplaneService.createAirplane(airplane);
        return ResponseEntity.status(201).body(createdAirplane.getId());

    }


}
