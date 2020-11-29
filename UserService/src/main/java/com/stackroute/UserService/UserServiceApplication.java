package com.stackroute.UserService;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.print.attribute.standard.MediaSize;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {
	@Value("${spring.rabbitmq.queue}")
	String queue;

	@Value("${spring.rabbitmq.exchange}")
	String exchange;

	@Value("${spring.rabbitmq.host}")
	String host;

	@Value("${spring.rabbitmq.username}")
	String userName;

	@Value("${spring.rabbitmq.password}")
	String password;

	@Bean
	Queue queue() {
		return new Queue(queue, true);
	}


	@Bean
	Exchange myExchange() {
		return ExchangeBuilder.directExchange(exchange).durable(true).build();
	}

	/*@Bean
	public CachingConnectionFactory factory(){
		CachingConnectionFactory factory = new CachingConnectionFactory(host);
		factory.setUsername(userName);
		factory.setPassword(password);
		return factory;
	}*/

	@Bean
	public MessageConverter messageConverter(){
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate template(ConnectionFactory factory){
		final RabbitTemplate template =  new RabbitTemplate(factory);
		template.setMessageConverter(messageConverter());
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
