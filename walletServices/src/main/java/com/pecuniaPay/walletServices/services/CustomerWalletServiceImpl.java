package com.pecuniaPay.walletServices.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.repositories.BankAccountRepository;
import com.pecuniaPay.walletServices.repositories.CustomerWalletRepository;
import com.pecuniaPay.walletServices.valueObjects.WalletBankAccountVO;

@Service
public class CustomerWalletServiceImpl implements CustomerWalletService {
	
	@Autowired
	private CustomerWalletRepository customerWalletRepo;
	
	@Autowired
	private BankAccountRepository bankAccRepo;

	@Override
	public CustomerWallet generateNewWallet(CustomerWallet customerWallet) {
		customerWallet.setWalletBalance(0l);
		return customerWalletRepo.save(customerWallet);
	}

}
