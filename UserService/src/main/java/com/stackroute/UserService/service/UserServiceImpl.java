package com.stackroute.UserService.service;

import com.stackroute.UserService.model.Order;
import com.stackroute.UserService.model.User;
import com.stackroute.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User saveUser(User user) {
        if(user.getUser_storeName()==null|| user.getUser_storeName().equals("")){
            user.setRole("patient");
        }
        else {
            user.setRole("supplier");
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

    @Override
    public void updateOrder(Order order) {
        List<Order> orderDetails;
        User user = repository.findByUserName(order.getOrderedBy());
        if (user.getOrderSummary() == null) {
             orderDetails = new ArrayList<>();
        } else {
            orderDetails = user.getOrderSummary();
        }
        orderDetails.add(order);
        Query query = new Query(Criteria.where("userName").is(order.getOrderedBy()));
        Update update = new Update();
        update.set("order", orderDetails);
        mongoTemplate.findAndModify(query, update, User.class);
    }
}
