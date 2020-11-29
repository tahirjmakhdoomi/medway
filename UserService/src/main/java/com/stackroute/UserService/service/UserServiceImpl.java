package com.stackroute.UserService.service;

import com.stackroute.UserService.model.User;
import com.stackroute.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User saveUser(User user) {
        if(user.getUser_storeName()==null|| user.getUser_storeName().equals("")){
            user.setRole("Customer");
        }
        else {
            user.setRole("Supplier");
        }
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getByUserName(String userName) {
        return repository.findByUserName(userName);
    }
}
