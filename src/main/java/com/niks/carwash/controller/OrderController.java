package com.niks.carwash.controller;

import com.niks.carwash.entity.Order;
import com.niks.carwash.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-management")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam (name = "clientID") final Long clientID,
                       @RequestParam (name = "position") final Long positionID) {
        orderService.create(clientID, positionID);
    }

    @GetMapping("/orders/")
    public List<Order> showAll() {
        return orderService.showAll();
    }


    @GetMapping("/orders/{ID}")
    public Order findByID(@PathVariable("ID") final Long ID) {
        return orderService.findByID(ID);
    }

    @DeleteMapping("/clients/{ID}")
    public void deleteByID(@PathVariable("ID") final Long ID) {
        orderService.removeByID(ID);
    }
}
