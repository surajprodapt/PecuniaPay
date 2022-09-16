package com.pecuniaPay.walletServices.services;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.valueObjects.WalletBankAccountVO;

public interface CustomerWalletService {
	
//	public CustomerWallet addBankAccounttoWallet(CustomerWallet customerWallet,BankAccount bankAccount);
	public CustomerWallet generateNewWallet(CustomerWallet cw);
	
	public CustomerWallet addBankAccounttoWallet(WalletBankAccountVO vo);
}
