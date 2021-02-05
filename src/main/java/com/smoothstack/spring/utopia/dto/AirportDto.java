package com.smoothstack.spring.utopia.dto;

import lombok.Data;

@Data
public class AirportDto {

    private Long id;

    private String city;
    private Long iataId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getIataId() {
        return iataId;
    }

    public void setIataId(Long iataId) {
        this.iataId = iataId;
    }
}
