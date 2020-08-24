package com.sneha.demo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sneha.demo.model.OrderTransaction;
import com.sneha.demo.repositories.OrderTransactionRepository;

@Component
public class OrderTransactionReceiver {
	
	@Autowired
	OrderTransactionRepository orderTransactionRepository;
	
	/**
	 * receive and save in Repo
	 * @param transaction
	 */
	@JmsListener(destination="OrderTransactionQueue", containerFactory = "myFactory")
	public void receiveMessage(OrderTransaction transaction) {
		System.out.println("Received <" + transaction + ">");
		orderTransactionRepository.save(transaction);	
	}

}
