package com.stackroute.orderservice.controller;

import com.stackroute.orderservice.model.Order;
import com.stackroute.orderservice.service.OrderService;
import com.stackroute.orderservice.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1")
public class OrderController {

    RabbitMqSender rabbitMqSender;
    OrderService service;
    @Autowired
    public OrderController(OrderService service, RabbitMqSender sender){
        this.service=service;
        this.rabbitMqSender=sender;
    }
    @PostMapping("/entry")
    public ResponseEntity<Order> entry(@RequestBody Order order){
        return new ResponseEntity<>(service.saveOrder(order), HttpStatus.CREATED);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> allOrders(){
        return new ResponseEntity<>(service.getAllOrders(), HttpStatus.OK);
    }

    @Value("${app.message}")
    private String message;

    @PostMapping(value = "order")
    public String publishOrderDetails(Order order){
        rabbitMqSender.send(order);
        return message;
    }
}
