package com.smoothstack.spring.utopia.dto;

import lombok.Data;

@Data
public class FlightDto {

    private Long id;

    private Long originId;
    private Long destinationId;
    private Long airplaneId;
    private Integer filledSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public Integer getFilledSeats() {
        return filledSeats;
    }

    public void setFilledSeats(Integer filledSeats) {
        this.filledSeats = filledSeats;
    }
}
