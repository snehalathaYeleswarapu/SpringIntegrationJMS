package com.sneha.demo.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "OrderTransaction")
@Getter
@Setter
@ToString(exclude = "id")
@NoArgsConstructor
public class OrderTransaction {
	
	@Id 
	private String id;
	private String from;
	private String to;
	private BigDecimal amount;
	
	public OrderTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderTransaction(String from, String to, BigDecimal amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
	}
	
	

}
