package com.medway.authservice.service;

import com.medway.authservice.model.User;

public interface UserService {
    public User add(User user);
    public User find(User user);
}
