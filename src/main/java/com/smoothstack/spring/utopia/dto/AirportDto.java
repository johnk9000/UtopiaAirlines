package com.smoothstack.spring.utopia.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AirportDto {

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Iata Id is mandatory")
    private String iataId;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIataId() {
        return iataId;
    }

    public void setIataId(String iataId) {
        this.iataId = iataId;
    }
}
