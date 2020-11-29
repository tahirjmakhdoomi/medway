package com.stackroute.UserService.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.orderqueue}")
    private String orderQueue;

    @Value("${spring.rabbitmq.orderexchange}")
    private String orderExchange;

    @Value("${spring.rabbitmq.orderroutingkey}")
    private String orderRoutingKey;

    @Value("${spring.rabbitmq.orderusername}")
    private String orderUsername;

    @Value("${spring.rabbitmq.orderpassword}")
    private String orderPassword;

    @Value("${spring.rabbitmq.orderhost}")
    private String orderHost;

    @Bean
    Queue orderQueue() {
        return new Queue(orderQueue, true);
    }

    @Bean
    Exchange orderExchange() {
        return ExchangeBuilder.directExchange(orderExchange).durable(true).build();
    }

    @Bean
    Binding orderBinding() {
        return BindingBuilder
                .bind(orderQueue())
                .to(orderExchange())
                .with(orderRoutingKey)
                .noargs();
    }

    @Bean
    ConnectionFactory orderConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(orderHost);
        cachingConnectionFactory.setUsername(orderUsername);
        cachingConnectionFactory.setPassword(orderPassword);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverterForOrder() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate orderRabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverterForOrder());
        return rabbitTemplate;
    }
}
