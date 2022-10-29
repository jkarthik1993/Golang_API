package com.golang.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golang.demo.model.Transaction;
import com.golang.demo.model.TransactionDto;
import com.golang.demo.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	
	
	@Autowired
	TransactionRepository transactionRepo;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepo.save(transaction);
	}

	@Override
	public List<TransactionDto> findAllTransaction() {
		List<TransactionDto> transactionEntity= new ArrayList<>();
		
		List<Object[]> transactionList= transactionRepo.findAllTransaction();
		if(transactionList!=null) {
			for(Object[] obj: transactionList) {
				TransactionDto tran=new TransactionDto();
				tran.setSum(obj[0].toString());
				tran.setAvg(obj[1].toString());
				tran.setMax(obj[2].toString());
				tran.setMin(obj[3].toString());
				tran.setCount(obj[4].toString());
				transactionEntity.add(tran);
			}	
		}
		return transactionEntity;
	}

	@Override
	public void deleteTransaction() {
		 transactionRepo.deleteAll();		
	}

	@Override
	public List<Transaction> finadTransaction() {
		return transactionRepo.findAll();
	}

}
