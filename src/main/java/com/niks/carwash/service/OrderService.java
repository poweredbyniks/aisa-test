package com.niks.carwash.service;

import com.niks.carwash.entity.Client;
import com.niks.carwash.entity.Order;
import com.niks.carwash.repository.ClientRepository;
import com.niks.carwash.repository.OrderRepository;
import com.niks.carwash.repository.PositionRepository;
import com.sun.istack.NotNull;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, PositionRepository positionRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.positionRepository = positionRepository;
    }


    @NotNull
    public void create(@NotNull final Long clientID, @NotNull final Long positionID) {
        Order order = new Order();
        order.setClient(clientRepository.getOne(clientID));
        order.setPositions(positionRepository.getOne(positionID));
        order.setPrice(positionRepository.getOne(positionID).getPrice());
        orderRepository.save(order);
    }

    public List<Order> showAll() {
        return orderRepository.findAll();
    }

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

