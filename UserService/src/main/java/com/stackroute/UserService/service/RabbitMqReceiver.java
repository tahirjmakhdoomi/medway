package com.stackroute.UserService.service;

import com.stackroute.UserService.model.Order;
import com.stackroute.UserService.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReceiver {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);


    @Autowired
    private UserServiceImpl userService;

    @RabbitListener(queues = "${spring.rabbitmq.orderqueue}")
    public void receivedMessage(Order order) {
        logger.info("Received order summary" + order);

        User user = userService.getByUserName(order.getOrderedBy());
        user.getOrderSummary().add(order);
        userService.saveUser(user);
    }

}
