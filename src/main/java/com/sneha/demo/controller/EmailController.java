package com.sneha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sneha.demo.model.Email;

import org.springframework.jms.core.JmsTemplate;

@RestController
@RequestMapping(value = "/mailBox")
public class EmailController {

	@Autowired
	JmsTemplate JmsTemplate;

	@PostMapping("/email/send")
	public void sendEmail(@RequestBody Email email) {
		System.out.println("Sending an email message>>>>>>");
		JmsTemplate.convertAndSend("mailBox", email);
	}

}
