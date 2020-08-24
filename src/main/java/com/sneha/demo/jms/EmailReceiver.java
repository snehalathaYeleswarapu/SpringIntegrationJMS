package com.sneha.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sneha.demo.model.Email;

/**
 * Message Driven POJO
 * @author Sneha
 *
 */
@Component
public class EmailReceiver {
	
	// This method is flexible and has no import on  JMS Api
	//Destination--> defines the name that it should listen on
	//REference of container factory is to create the underlying msg listener container (optional)-- required only if it 
	//has to be customized
	@JmsListener(destination = "mailBox", containerFactory = "myFactory")
	public void receiveMessage(Email email) {
		System.out.println("Received Email< " + email + ">");
		}

}
