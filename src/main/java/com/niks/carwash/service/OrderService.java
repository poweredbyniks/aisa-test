package com.niks.carwash.service;

import com.niks.carwash.OrderProcessor;
import com.niks.carwash.entity.Order;
import com.niks.carwash.repository.ClientRepository;
import com.niks.carwash.repository.OrderRepository;
import com.niks.carwash.repository.PositionRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Queue;


@EnableScheduling
@Transactional
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository,
                        PositionRepository positionRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.positionRepository = positionRepository;
    }


    @NotNull
    public void create(@NotNull final Long clientID, @NotNull final Long positionID, @NotNull final LocalDateTime dateTime) {


        Order order = new Order();
        order.setClient(clientRepository.getOne(clientID));
        order.setPositions(positionRepository.getOne(positionID));
        order.setPrice(positionRepository.getOne(positionID).getPrice());
        order.setOrderDate(dateTime);
        LocalDateTime endTime = dateTime.plusMinutes(order.getPositions().getDuration())
        if (checkAvailability(dateTime, endTime)) {
            orderRepository.save(order);
        }
    }

    private boolean checkAvailability(LocalDateTime inputStartTime, LocalDateTime inputEndTime) {
        LocalDateTime startTime = orderRepository.findByOrOrderDateEquals().getOrderDate();
        LocalDateTime endTime =
                startTime.plusMinutes(orderRepository.findByOrOrderDateEquals().getPositions().getDuration());
        return !inputStartTime.isEqual(startTime) || !inputEndTime.isEqual(endTime);
    }

    //
//    public Queue<Order> currentOrders() {
//        return orderProcessor.currentOrders();
//    }
//
    public List<Order> showAll() {
        return orderRepository.findAll();
    }
//
//    public Long waitingTime() {
//        return orderProcessor.waitingTime();
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

