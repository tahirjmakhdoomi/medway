package com.medway.medway.controller;


import com.medway.medway.model.User;
import com.medway.medway.service.UserServiceImpl;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private UserServiceImpl service;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping("/adduser")
    public String addUser(@RequestBody User u){
        service.add(u);
        return u.toString();
    }

    @PostMapping("/validate")
    public String validate(@RequestBody User u){

        User fetch = service.find(u);
        if(fetch == null) return "Invalid Credentials";

        return null;
    }

    @GetMapping("/producer")
    public String sendData(){
        amqpTemplate.convertAndSend("userexchange","users", "Helllo");

        return "Message sent";
    }
}
