package com.stackroute.orderservice.service;

import com.stackroute.orderservice.model.Order;
import com.stackroute.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    OrderRepository repository;
    @Autowired
    public OrderServiceImpl(OrderRepository repository){
        this.repository=repository;
    }

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }
}
