package com.niks.carwash.service;

import com.niks.carwash.entity.Position;
import com.niks.carwash.repository.PositionRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @NotNull
    public void create(@NotNull final Position pricePosition) {
        positionRepository.save(pricePosition);
    }

    @NotNull
    public List<Position> findAll(){
        return positionRepository.findAll();
    }

    @NotNull
    public Position findByID(@NotNull final Long ID) {
        Position pricePosition = null;
        if (positionRepository.findById(ID).isPresent()) {
            pricePosition = positionRepository.findById(ID).get();
        }
        return pricePosition;
    }

    @NotNull
    public List<Position> findByName(@NotNull final String name) {
        return positionRepository.findPricePositionByName(name);
    }

    @NotNull
    public void removeByID(@NotNull final Long ID) {
        positionRepository.deleteById(ID);
    }
}
