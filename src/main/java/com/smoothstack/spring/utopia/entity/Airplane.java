package com.smoothstack.spring.utopia.entity;

public class Airplane {

    private int id;
    private AirplaneType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }
}
