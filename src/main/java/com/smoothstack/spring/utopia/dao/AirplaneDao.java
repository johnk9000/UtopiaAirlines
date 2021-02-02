package com.smoothstack.spring.utopia.dao;

import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.entity.AirplaneType;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AirplaneDao {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/utopia";
    private final String username = "neil";
    private final String password = "php8734";


    public Airplane getAirplaneById(int planeId) throws ClassNotFoundException, SQLException {
        //set up driver and connection
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM airplane WHERE id = ?");
        prepStmt.setInt(1, planeId);
        ResultSet rs = prepStmt.executeQuery();

        int id = rs.getInt("id");

        prepStmt = conn.prepareStatement("SELECT * FROM airplane_type WHERE id = ?");
        prepStmt.setInt(1, rs.getInt("type_id"));
        rs = prepStmt.executeQuery();

        AirplaneType type = new AirplaneType();
        type.setId(rs.getInt("id"));
        type.setMaxCapacity(rs.getInt("max_capacity"));

        Airplane airplane = new Airplane();
        airplane.setId(id);
        airplane.setType(type);

        return airplane;

    }

    public List<Airplane> getAirplanesByType(AirplaneType type) throws ClassNotFoundException, SQLException {
        //set up driver and connection
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);

        PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM airplane WHERE type_id = ?");
        prepStmt.setInt(1, type.getId());
        ResultSet rs = prepStmt.executeQuery();
        List<Airplane> airplanes = new ArrayList<>();
        while (rs.next())
        {
            Airplane airplane = new Airplane();
            airplane.setId(rs.getInt("id"));
            airplane.setType(type);
            airplanes.add(airplane);
        }

        return airplanes;
    }
}
