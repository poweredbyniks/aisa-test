package com.niks.carwash.repository;

import com.niks.carwash.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

}
