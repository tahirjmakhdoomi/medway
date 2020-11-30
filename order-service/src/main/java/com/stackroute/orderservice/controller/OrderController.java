package com.stackroute.orderservice.controller;

import com.stackroute.orderservice.model.Order;
import com.stackroute.orderservice.service.OrderService;
import com.stackroute.orderservice.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1")
public class OrderController {
    OrderService service;
    RabbitMQSender sender;

    @Autowired
    public OrderController(OrderService service,RabbitMQSender sender){
        this.service=service;
        this.sender = sender;
    }
    @PostMapping("/entry")
    public ResponseEntity<Order> entry(@RequestBody Order order){
        sender.send(order);
        return new ResponseEntity<>(service.saveOrder(order), HttpStatus.CREATED);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> allOrders(){
        return new ResponseEntity<>(service.getAllOrders(), HttpStatus.OK);}
}
