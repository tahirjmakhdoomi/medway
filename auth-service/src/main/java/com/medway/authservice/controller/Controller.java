package com.medway.authservice.controller;


import com.medway.authservice.configuration.JwtUtil;
import com.medway.authservice.model.User;
import com.medway.authservice.service.UserServiceImpl;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    private UserServiceImpl service;

//    @Autowired
//    private AmqpTemplate amqpTemplate;

    @Autowired
    private JwtUtil jwt;

//    @PostMapping("/adduser")
//    public String addUser(@RequestBody User u){
//        service.add(u);
//        return u.toString();
//    }

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestBody User u, HttpServletResponse httpServletResponse){

        User fetch = service.find(u);

        Cookie jwtCookie = new Cookie("token",null);
        jwtCookie.setSecure(false);
        jwtCookie.setPath("/");
        jwtCookie.setHttpOnly(true);

        if(fetch == null) {
            httpServletResponse.addCookie(jwtCookie);
            return new ResponseEntity<>("Invalid Credentials", HttpStatus.FORBIDDEN);
        }

        String token = jwt.generateToken(fetch);
        jwtCookie.setValue(token);
        httpServletResponse.addCookie(jwtCookie);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

//    @GetMapping("/securedEndpoint")
//    public String secured(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
//        System.out.println(httpServletRequest.getCookies()[0].getValue());
//        Cookie jwtCookie = new Cookie("token",null);
//        jwtCookie.setSecure(false);
//        jwtCookie.setPath("/");
//        jwtCookie.setHttpOnly(true);
//        httpServletResponse.addCookie(jwtCookie);
//        return "This is secured endpoint";
//
//    }

//    @GetMapping("/producer")
//    public String sendData(){
//        amqpTemplate.convertAndSend("userexchange","users", "Helllo");
//
//        return "Message sent";
//    }



}
