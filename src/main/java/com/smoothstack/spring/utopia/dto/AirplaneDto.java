package com.smoothstack.spring.utopia.dto;

import lombok.Data;

@Data
public class AirplaneDto {

    private Long id;
    private Integer maxCapacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
