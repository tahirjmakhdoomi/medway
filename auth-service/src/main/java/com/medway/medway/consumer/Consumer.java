package com.medway.medway.consumer;

import com.medway.medway.model.User;
import com.medway.medway.service.UserServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private UserServiceImpl service;

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void receive(String string){

        service.add(new User("Username1","Password", "role"));
        System.out.println(string);
    }

}
