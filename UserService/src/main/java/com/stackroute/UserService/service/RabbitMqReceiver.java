package com.stackroute.UserService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.UserService.model.Order;
import com.stackroute.UserService.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class RabbitMqReceiver {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${spring.rabbitmq.orderqueue}")
    public void receivedMessage(Order data) throws JsonProcessingException {
        System.out.println("data:"+data);

        userService.updateOrder(data);

//        Order order = objectMapper.readValue(data, Order.class);
//        User user = userService.getByUserName(data.getOrderedBy());
//        user.getOrderSummary().add(data);
//        System.out.println("User order after add:"+user.getOrderSummary());
//        userService.saveUser(user);

       /* User user = userService.getByUserName(order.getOrderedBy());
        user.getOrderSummary().add(order);
        userService.saveUser(user);*/
    }

}
