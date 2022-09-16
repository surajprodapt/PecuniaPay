package com.pecuniaPay.walletServices.services;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.valueObjects.WalletBankAccountVO;

public interface BankAccountService {
	
	public WalletBankAccountVO addBankAccount(WalletBankAccountVO valueObject);
	
	public void deleteBankAccountByAccountNumber(Long accountNumber);
	
}
