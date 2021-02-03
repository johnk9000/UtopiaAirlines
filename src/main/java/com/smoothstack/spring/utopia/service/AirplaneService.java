package com.smoothstack.spring.utopia.service;

import com.smoothstack.spring.utopia.dao.AirplaneDao;
import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.entity.AirplaneType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class AirplaneService {

    @Autowired
    private AirplaneDao airplaneDao;

    public Airplane getAirplaneById(int planeId)
    {
        Airplane airplane = null;
        try {
            airplane = airplaneDao.getAirplaneById(planeId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return airplane;
    }

    public List<Airplane> getAirplanesByType(int typeId)
    {
        List<Airplane> airplanes = null;
        try {
            airplanes = airplaneDao.getAirplanesByType(typeId);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return airplanes;
    }

}
