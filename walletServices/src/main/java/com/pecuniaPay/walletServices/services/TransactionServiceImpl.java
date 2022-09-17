package com.pecuniaPay.walletServices.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.entities.Transaction;
import com.pecuniaPay.walletServices.repositories.CustomerWalletRepository;
import com.pecuniaPay.walletServices.repositories.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private CustomerWalletRepository customerWalletRepository;
	
	@Autowired
	private TransactionRepository transactionrepository;
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		transaction.setTransactionDateTime(LocalDateTime.now());
		CustomerWallet customerWallet = customerWalletRepository.findById(transaction.getWalletId()).get();
		CustomerWallet recieversCustomerWallet = customerWalletRepository.findById(transaction.getRecieverWalletId()).get();
		customerWallet.setWalletBalance(customerWallet.getWalletBalance()-transaction.getAmount());
		recieversCustomerWallet.setWalletBalance(recieversCustomerWallet.getWalletBalance()+transaction.getAmount());
		customerWalletRepository.save(customerWallet);
		customerWalletRepository.save(recieversCustomerWallet);
		return transactionrepository.save(transaction);
	}
	
	@Override
	public List<Transaction> getAllTransactions(Long walletId) {
		return transactionrepository.findByWalletIdOrRecieverWalletId(walletId,walletId);
	}
}
