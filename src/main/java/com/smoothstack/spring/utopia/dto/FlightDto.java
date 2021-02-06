package com.smoothstack.spring.utopia.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;

@Data
public class FlightDto {

    @NotNull(message = "Origin airport number is required")
    private Long originId;

    @NotNull(message = "Destination airport number is required")
    private Long destinationId;

    @NotNull(message = "Airplane number is required")
    private Long airplaneId;

    @NotNull(message = "Number of filled seats is required")
    private Integer filledSeats;

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
