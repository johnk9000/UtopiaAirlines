package com.smoothstack.spring.utopia.controller;

import com.smoothstack.spring.utopia.dto.AirplaneDto;
import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.entity.Flight;
import com.smoothstack.spring.utopia.mapper.AirplaneDtoMapper;
import com.smoothstack.spring.utopia.mapper.FlightDtoMapper;
import com.smoothstack.spring.utopia.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAirplane(@PathVariable Long id, @Valid @RequestBody AirplaneDto airplaneDto)
    {
        if (id == null)
            return ResponseEntity.badRequest().body(Map.of("message", "Airplane ID is required for update"));

        AirplaneDtoMapper airplaneDtoMapper = new AirplaneDtoMapper();
        Airplane airplaneToUpdate = airplaneDtoMapper.map(airplaneDto);
        airplaneToUpdate.setId(id);
        try{
            Airplane updatedAirplane = airplaneService.updateAirplane(airplaneToUpdate);
            return ResponseEntity.ok(updatedAirplane);
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirplane(@PathVariable Long id)
    {
        if(airplaneService.airplaneInFlight(id))
            return ResponseEntity.status(405).body("Can't delete airplane in flight");
        airplaneService.deleteAirplane(id);
        return ResponseEntity.noContent().build();
    }


}
