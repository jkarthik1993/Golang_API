package com.golang.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.golang.demo.model.Transaction;
import com.golang.demo.model.TransactionDto;
import com.golang.demo.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("transaction")
	public ResponseEntity<List<TransactionDto>> getAllTransaction(){
		return ResponseEntity.ok().body(transactionService.findAllTransaction());
	}
	
	@GetMapping("transactionAll")
	public ResponseEntity<List<Transaction>> gettransactionAll(){
		return ResponseEntity.ok().body(transactionService.finadTransaction());
	}
	
	@PostMapping("transaction")
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
		return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
		
	}
	
	
	
	@DeleteMapping("transaction")
	public ResponseEntity deleteTransaction(){
		transactionService.deleteTransaction();
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
