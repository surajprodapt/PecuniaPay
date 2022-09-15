package com.pecuniaPay.walletServices.services;

import com.pecuniaPay.walletServices.entities.BankAccount;

public interface BankAccountService {
	
	public BankAccount addBankAccount(BankAccount bankAccount);
	
	public void deleteBankAccountByAccountNumber(Long accountNumber);
	
}
