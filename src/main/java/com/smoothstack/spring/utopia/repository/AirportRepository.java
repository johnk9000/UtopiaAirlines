package com.smoothstack.spring.utopia.repository;

import com.smoothstack.spring.utopia.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
