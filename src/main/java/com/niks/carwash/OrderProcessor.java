package com.niks.carwash;

import com.niks.carwash.entity.Order;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrderProcessor {

    Queue<Order> queue = new ConcurrentLinkedQueue<>();

    public void addToQueue(Order order) {
        queue.add(order);
    }

    public Long waitingTime(Queue<Order> queue) {
        Iterator<Order> iterator = queue.iterator();
        long totalDuration = 0L;
        while (iterator.hasNext()) {
            long duration = iterator.next().getPositions().getDuration();
            totalDuration = totalDuration + duration;
        }

        return totalDuration;
    }
}


//try {
//            queue.remove();
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//        }