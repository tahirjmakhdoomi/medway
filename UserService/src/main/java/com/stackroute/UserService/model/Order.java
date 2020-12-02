package com.stackroute.UserService.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id",
        scope = Order.class)
public class Order implements Serializable {
    private String orderedBy;
    private Long orderedOn;
    private String user_email;
    private long user_phone;
    private String user_address1;
    private String user_address2;
    private String user_city;
    private String user_pin;
    private String user_state;
    private boolean paymentStatus;
    private List<OrderDetails> orderDetails;

    public Order(){

    }

    public Order(String orderedBy, Long orderedOn, String user_email, long user_phone,
                 String user_address1, String user_address2, String user_city, String user_pin,
                 String user_state, boolean paymentStatus, List<OrderDetails> orderDetails) {
        this.orderedBy = orderedBy;
        this.orderedOn = orderedOn;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_address1 = user_address1;
        this.user_address2 = user_address2;
        this.user_city = user_city;
        this.user_pin = user_pin;
        this.user_state = user_state;
        this.paymentStatus = paymentStatus;
        this.orderDetails = orderDetails;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy;
    }

    public Long getOrderedOn() {
        return orderedOn;
    }

    public void setOrderedOn(Long orderedOn) {
        this.orderedOn = orderedOn;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public long getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(long user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address1() {
        return user_address1;
    }

    public void setUser_address1(String user_address1) {
        this.user_address1 = user_address1;
    }

    public String getUser_address2() {
        return user_address2;
    }

    public void setUser_address2(String user_address2) {
        this.user_address2 = user_address2;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_pin() {
        return user_pin;
    }

    public void setUser_pin(String user_pin) {
        this.user_pin = user_pin;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderSummary{" +
                "orderedBy='" + orderedBy + '\'' +
                ", orderedOn=" + orderedOn +
                ", user_email='" + user_email + '\'' +
                ", user_phone=" + user_phone +
                ", user_address1='" + user_address1 + '\'' +
                ", user_address2='" + user_address2 + '\'' +
                ", user_city='" + user_city + '\'' +
                ", user_pin='" + user_pin + '\'' +
                ", user_state='" + user_state + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
