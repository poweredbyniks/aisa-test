package com.niks.carwash;

import com.niks.carwash.entity.Order;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrderProcessor {

    Queue<Order> queue = new ConcurrentLinkedQueue<>();

    public void addToQueue(Order order) {
        queue.add(order);
    }

    public void beforeCurrent(Queue<Order> queue) {
        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }
}
