package com.smoothstack.spring.utopia.repository;

import com.smoothstack.spring.utopia.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
