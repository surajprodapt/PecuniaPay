package com.pecuniaPay.walletServices.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecuniaPay.walletServices.entities.Transaction;
import com.pecuniaPay.walletServices.repositories.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionrepository;
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		transaction.setTransactionDateTime(LocalDateTime.now());
		return transactionrepository.save(transaction);
	}
	@Override
	public List<Transaction> getAllTransactions(Long walletId) {
		return transactionrepository.findByWalletId(walletId);
	}

}
