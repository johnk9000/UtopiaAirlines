package com.smoothstack.spring.utopia.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Airport origin;

    @OneToOne
    private Airport destination;

    @OneToOne
    private Airplane airplane;

    private Integer filledSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Integer getFilledSeats() {
        return filledSeats;
    }

    public void setFilledSeats(Integer filledSeats) {
        this.filledSeats = filledSeats;
    }
}
