package com.medway.authservice.service;

import com.medway.authservice.model.User;
import com.medway.authservice.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Repo r;

    public User add(User user){
        return r.save(user);
    }

    @Override
    public User find(String username, String password) {
        User u = r.findByUserNameAndPassword(username,password);
        //System.out.println(u.toString());
        return u;
    }
}
