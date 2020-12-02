package com.stackroute.UserService.controller;


import com.stackroute.UserService.model.User;
import com.stackroute.UserService.service.RabbitMqSender;
import com.stackroute.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class UserController {

    private RabbitMqSender sender;

    UserService service;

    @Autowired
    public UserController(UserService service,RabbitMqSender sender) {
        this.service = service;
        this.sender = sender;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        sender.send(user);
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> allUsers(){
        return new ResponseEntity<>(service.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("orders/{userName}")
    public ResponseEntity<User> getByUser_name(@PathVariable("userName") String userName){
        return new ResponseEntity<>(service.getByUserName(userName), HttpStatus.OK);
    }
}
