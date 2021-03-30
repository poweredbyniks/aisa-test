package com.niks.carwash.repository;

import com.niks.carwash.entity.Position;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    @NotNull
    List<Position> findPricePositionByName(@NotNull final String name);

}
