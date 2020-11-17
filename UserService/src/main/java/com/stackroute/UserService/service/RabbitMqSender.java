package com.stackroute.UserService.service;

import com.stackroute.UserService.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    private RabbitTemplate template;

    @Autowired
    public RabbitMqSender(RabbitTemplate template) {
        this.template = template;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    public void send(User user){
        template.convertAndSend(exchange,routingKey,user);
    }
}
