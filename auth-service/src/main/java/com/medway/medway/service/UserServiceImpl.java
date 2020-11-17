package com.medway.medway.service;

import com.medway.medway.model.User;
import com.medway.medway.repository.Repo;
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
    public User find(User user) {
        User u = r.findByUserNameAndPassword(user.getUserName(),user.getPassword());

        return u;
    }
}
