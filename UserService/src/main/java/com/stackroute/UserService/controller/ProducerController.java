//package com.stackroute.UserService.controller;
//
//import com.stackroute.UserService.model.User;
//import com.stackroute.UserService.service.RabbitMqSender;
//import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1")
//public class ProducerController {
//
//    private RabbitMqSender sender;
//
//    @Autowired
//    public ProducerController(RabbitMqSender sender) {
//        this.sender = sender;
//    }
//
//    @Value("${app.message}")
//    private String message;
//
//    @PostMapping("/register")
//    public String register(@RequestBody User user){
//        sender.send(user);
//        return message;
//    }
//}
