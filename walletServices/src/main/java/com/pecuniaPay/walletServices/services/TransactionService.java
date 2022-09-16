package com.pecuniaPay.walletServices.services;

import java.util.List;

import com.pecuniaPay.walletServices.entities.Transaction;

public interface TransactionService {
	public Transaction saveTransaction(Transaction transaction);

	public List<Transaction> getAllTransactions(Long walletId);
}
