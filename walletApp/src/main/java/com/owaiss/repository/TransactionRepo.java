package com.owaiss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.owaiss.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
