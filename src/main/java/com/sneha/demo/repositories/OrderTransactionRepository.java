package com.sneha.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sneha.demo.model.OrderTransaction;

public interface OrderTransactionRepository extends MongoRepository<OrderTransaction, String> {}

