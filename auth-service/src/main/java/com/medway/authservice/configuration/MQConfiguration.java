package com.medway.authservice.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfiguration {
    @Value(value = "${rabbit.queue.name}")
    String userqueue;

    @Value("${rabbit.exchange.name}")
    String exchange;

    @Value("${rabbit.routing.key}")
    String routingKey;

    @Bean
    Queue userQueue(){
        return new Queue(userqueue,true);
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue userQueue, DirectExchange directExchange){
        return BindingBuilder.bind(userQueue).to(directExchange).with(routingKey);
    }

}
