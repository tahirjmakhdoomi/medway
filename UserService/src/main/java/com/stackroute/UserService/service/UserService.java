package com.stackroute.UserService.service;


import com.stackroute.UserService.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
}
