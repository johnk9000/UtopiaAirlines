package com.smoothstack.spring.utopia.repository;

import com.smoothstack.spring.utopia.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
