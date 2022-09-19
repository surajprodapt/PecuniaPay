package com.pecuniaPay.walletServices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pecuniaPay.walletServices.entities.Transaction;
import com.pecuniaPay.walletServices.services.BankAccountService;
import com.pecuniaPay.walletServices.services.TransactionService;
import com.pecuniaPay.walletServices.valueObjects.BankToWalletVO;
//http://localhost:8060/wallet
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@PostMapping("/sendmoney")
	public Transaction sendMoneyfromWallet(@RequestBody Transaction transaction)
	{
		return transactionService.saveTransaction(transaction);
	}
	
//	send money will act as recieve money for the beneficiary account
//	@GetMapping("/recievemoney")
//	public void recievetMoneyinWallet()
//	{
//		
//	}
	
	@GetMapping("/getalltransactions/{id}")
	public List<Transaction> getAllTransactions(@PathVariable ("id") Long walletId)
	{
		return transactionService.getAllTransactions(walletId);
	}
	
	@PostMapping("/addmoney")
	public BankToWalletVO addMoneytoWallet(@RequestBody BankToWalletVO bankToWalletVO)
	{
		return bankAccountService.addMoneyToWallet(bankToWalletVO);
	}
}
