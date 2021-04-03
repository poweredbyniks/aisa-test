package com.niks.carwash;

import com.niks.carwash.entity.Order;
import com.niks.carwash.service.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//@Component
public class OrderProcessor {
//
//    private final Queue<Order> queue = new ConcurrentLinkedQueue<>();
//    private Long totalDuration = 0L;
//
//    private final OrderService orderService;
//
//    public OrderProcessor(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    public void addToQueue(Order order) {
//        queue.add(order);
//    }
//
//    public Queue<Order> currentOrders() {
//        return queue;
//    }
//
//    @Scheduled(fixedRate = 300000) //5 min
//    public void execution() {
//        executionCheck(queue);
//    }
//
//    public void executionCheck(Queue<Order> queue) {
//        Iterator<Order> iterator = queue.iterator();
//        //long totalDuration = 0L;
//        while (iterator.hasNext()) {
//            long duration = iterator.next().getPositions().getDuration();
//            totalDuration = totalDuration + duration;
//        }
//        if (300000 == Objects.requireNonNull(queue.peek()).getPositions().getDuration()) {
//            orderService.removeByID(queue.peek().getOrderID());
//            queue.remove();
//            totalDuration = 0L;
//        } else {
//            totalDuration = totalDuration - 300000;
//        }
//    }
//
//    public Long waitingTime() {
//        return totalDuration;
//    }
}