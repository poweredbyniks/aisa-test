package com.niks.carwash.controller;

import com.niks.carwash.entity.Position;
import com.niks.carwash.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position-management")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/positions")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Position position) {
        positionService.create(position);
    }

    @GetMapping("/positions")
    public List<Position> showAll() {
        return positionService.findAll();
    }

    @GetMapping("/positions/{ID}")
    public Position findByID(@PathVariable("ID") final Long ID) {
        return positionService.findByID(ID);
    }

    @GetMapping("/positions/{name}")
    public List<Position> findByName(@PathVariable("name") final String name) {
        return positionService.findByName(name);
    }

    @DeleteMapping("/positions/{ID}")
    public void deleteByID(@PathVariable("ID") final Long ID) {
        positionService.removeByID(ID);
    }
}
