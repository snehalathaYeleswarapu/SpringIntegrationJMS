package com.sneha.demo;

import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.util.ErrorHandler;


/**
 * @author Sneha
 *
 */
@SpringBootApplication
@EnableJms
@ComponentScan(basePackages = "com.sneha.demo")
@EnableMongoRepositories(basePackages = "com.sneha.demo")
public class SpringBootJmsIntegrationApplication {
	
	 private static final Logger log = LoggerFactory.getLogger(SpringBootJmsIntegrationApplication.class);
	 
	// Only required due to defining myFactory in the receiver
	@Bean
	JmsListenerContainerFactory<?> myFactory
	(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer defaultJmsListenerContainerFactoryConfigurer){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the message converter
		
		
		// anonymous class
	    factory.setErrorHandler(
	        new ErrorHandler() {
	          @Override
	          public void handleError(Throwable t) {
	            log.warn("An error has occurred in the transaction", t);
	          }
	        });

	    // lambda function
	    factory.setErrorHandler(t -> log.warn("An error has occurred in the transaction", t));
	    
		defaultJmsListenerContainerFactoryConfigurer.configure(factory, connectionFactory);
		return factory;
	}
	
	// Serialize message content to json using TextMessage
	@Bean
	public MessageConverter jmsMessageConvertor() {
		 MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		 converter.setTargetType(MessageType.TEXT);
		 converter.setTypeIdPropertyName("_type");
		 return converter;
	}

	public static void main(String[] args) {
		/*
		 * ConfigurableApplicationContext
		 * configurableApplicationContext=SpringApplication.run(
		 * SpringBootJmsIntegrationApplication.class, args); JmsTemplate
		 * jmsTemplate=configurableApplicationContext.getBean(JmsTemplate.class);
		 * System.out.println("Sending an email message>>>>>>");
		 * jmsTemplate.convertAndSend("mailBox", new Email("test@ex.com","Hello"));
		 */
		SpringApplication.run(SpringBootJmsIntegrationApplication.class, args);
	}

}
