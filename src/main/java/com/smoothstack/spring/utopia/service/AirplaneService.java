package com.smoothstack.spring.utopia.service;

import com.smoothstack.spring.utopia.repository.AirplaneRepository;
import com.smoothstack.spring.utopia.entity.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

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
}
