package com.pecuniaPay.walletServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.repositories.BankAccountRepository;
@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private BankAccountRepository baRepo;
	
	@Override
	public BankAccount addBankAccount(BankAccount bankAccount) {
		return baRepo.save(bankAccount);
	}

	@Override
	public void deleteBankAccountByAccountNumber(Long accountNumber) {
		baRepo.deleteById(accountNumber);
	}
	
	
}
