package com.medway.authservice.repository;


import com.medway.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String userName, String password);
}
