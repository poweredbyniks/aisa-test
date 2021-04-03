package com.niks.carwash.controller;

import com.niks.carwash.entity.Order;
import com.niks.carwash.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Queue;

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
    public void create(@RequestParam(name = "clientID") final Long clientID,
                       @RequestParam(name = "position") final Long positionID,
                       @RequestParam(name = "time") final LocalDateTime dateTime) {
        orderService.create(clientID, positionID, dateTime);
    }

//    @GetMapping("/current-orders")
//    public Queue<Order> currentOrders() {
//        return orderService.currentOrders();
//    }
//
//    @GetMapping("/waiting-time")
//    public Long waitingTime() {
//        return orderService.waitingTime();
//    }
//
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
