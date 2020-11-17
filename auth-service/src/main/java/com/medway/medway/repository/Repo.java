package com.medway.medway.repository;


import com.medway.medway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<User, String> {
    User findByUserNameAndPassword(String userName, String password);
}
