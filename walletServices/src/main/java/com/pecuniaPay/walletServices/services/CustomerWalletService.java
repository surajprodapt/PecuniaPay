package com.pecuniaPay.walletServices.services;

import com.pecuniaPay.walletServices.entities.CustomerWallet;

public interface CustomerWalletService {
	
//	public CustomerWallet addBankAccounttoWallet(CustomerWallet customerWallet,BankAccount bankAccount);
	public CustomerWallet generateNewWallet(CustomerWallet customerWallet);

	public Long getWalletBalance(Long walletId);
}
