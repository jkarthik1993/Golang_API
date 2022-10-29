package com.golang.demo.service;

import java.util.List;

import com.golang.demo.model.Transaction;
import com.golang.demo.model.TransactionDto;

public interface TransactionService {

	Transaction createTransaction(Transaction transaction);
	List<TransactionDto> findAllTransaction();
	List <Transaction> finadTransaction();
	void deleteTransaction();
	
	
}
