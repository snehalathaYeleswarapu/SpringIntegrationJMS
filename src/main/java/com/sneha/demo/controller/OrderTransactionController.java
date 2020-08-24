package com.sneha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sneha.demo.model.OrderTransaction;

@RestController
@RequestMapping(value = "/order")
public class OrderTransactionController {
	
	@Autowired
	JmsTemplate JmsTemplate;
	
	@PostMapping("/transaction/send")
	public void sendTransaction(@RequestBody OrderTransaction transaction) {
		System.out.println("Sending a transaction>>>>");
		JmsTemplate.convertAndSend("OrderTransactionQueue",transaction);
	}
	

}
