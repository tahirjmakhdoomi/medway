package com.stackroute.UserService.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"user_name","user_email","user_phone"})})
@Document("users")
public class User implements Serializable {

    private String name;
    private String user_name;
    private String user_email;
    private String user_password;
    private long user_phone;
    private String user_storeName;
    private String user_city;
    private int user_pin;
    private String user_state;

    public User(String name,String user_name, String user_email, String user_password, long user_phone, String user_storeName, String user_city, int user_pin, String user_state) {
        this.name = name;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_storeName = user_storeName;
        this.user_city = user_city;
        this.user_pin = user_pin;
        this.user_state = user_state;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public long getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(long user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_storeName() {
        return user_storeName;
    }

    public void setUser_storeName(String user_storeName) {
        this.user_storeName = user_storeName;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public int getUser_pin() {
        return user_pin;
    }

    public void setUser_pin(int user_pin) {
        this.user_pin = user_pin;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_phone=" + user_phone +
                ", user_storeName='" + user_storeName + '\'' +
                ", user_city='" + user_city + '\'' +
                ", user_pin=" + user_pin +
                ", user_state='" + user_state + '\'' +
                '}';
    }
}
