package com.smoothstack.spring.utopia.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AirplaneDto {

    @NotNull(message = "Max capacity required")
    private Integer maxCapacity;

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
