package com.golang.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.golang.demo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select SUM(t.amount),Round(SUM(t.amount)/COUNT(t.id),2),MAX(t.amount),MIN(t.amount),COUNT(t.id) from Transaction t")
	List<Object[]> findAllTransaction();
	
	
}
