package com.stackroute.orderservice.service;

import com.stackroute.orderservice.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    private RabbitTemplate template;

    @Autowired
    public RabbitMQSender(RabbitTemplate template) {
        this.template = template;
    }

    @Value("${spring.rabbitmq.exchange}")
    String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    String routingKey;

    public void send(Order order){
        template.convertAndSend(exchange,routingKey,order);
    }
}
