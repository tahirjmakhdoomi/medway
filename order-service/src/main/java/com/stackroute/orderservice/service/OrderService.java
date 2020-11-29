package com.stackroute.orderservice.service;

import com.stackroute.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
}
