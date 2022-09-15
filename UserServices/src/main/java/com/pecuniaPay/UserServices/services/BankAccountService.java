package com.pecuniaPay.UserServices.services;

import com.pecuniaPay.UserServices.entities.BankAccount;

public interface BankAccountService {
	
	public BankAccount addBankAccount(BankAccount bankAccount);
	
	public void deleteBankAccountByAccountNumber(Long accountNumber);
	
}
