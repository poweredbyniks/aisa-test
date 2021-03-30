package com.niks.carwash.service;

import com.niks.carwash.entity.Order;
import com.niks.carwash.repository.OrderRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Transactional
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @NotNull
    public void create(@NotNull final Order order) {
        LocalTime orderStart = order.getTimeStart();
        LocalDate orderDate = order.getDate();
        boolean isDiscounted = (orderStart.isBefore(LocalTime.parse("07:00"))
                &&
                orderStart.isAfter(LocalTime.parse("23:00"))
                || orderDate.getDayOfWeek() == DayOfWeek.SATURDAY
                || order.getDate().getDayOfWeek() == DayOfWeek.SUNDAY);
        if (isDiscounted) {
            order.setTotalPrice(order.getTotalPrice() * 0.7);
            orderRepository.save(order);
        }
    }

    public List<Order> showAll() {
        return orderRepository.findAll();
    }

//    public Long waitingTime() {
//
//    }

    @NotNull
    public Order findByID(@NotNull final Long ID) {
        Order order = null;
        if (orderRepository.findById(ID).isPresent()) {
            order = orderRepository.findById(ID).get();
        }
        return order;
    }

    @NotNull
    public void removeByID(@NotNull final Long ID) {
        orderRepository.deleteById(ID);
    }

}

