package com.medway.authservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medway.authservice.model.User;
import com.medway.authservice.model.UserDTO;
import com.medway.authservice.service.UserServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private UserServiceImpl service;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void receive(String data) throws JsonProcessingException {

        System.out.println(data);
        UserDTO dto = objectMapper.readValue(data,UserDTO.class);

        System.out.println(dto.toString());
        String userrole = "patient";
        if(dto.getUser_storeName() != null) userrole = "supplier";
        System.out.println(dto.getUser_name());
        service.add(new User(dto.getUser_name(), dto.getUser_password(), dto.getUser_email(), dto.getUser_phone(), userrole));
        //System.out.println(string);
    }

}
