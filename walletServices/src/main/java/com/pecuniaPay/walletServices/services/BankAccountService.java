package com.pecuniaPay.walletServices.services;

import java.util.List;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.valueObjects.BankAccountsVO;
import com.pecuniaPay.walletServices.valueObjects.BankToWalletVO;
import com.pecuniaPay.walletServices.valueObjects.WalletBankAccountVO;

public interface BankAccountService {
	
	public WalletBankAccountVO addBankAccount(WalletBankAccountVO valueObject);
	
	public void deleteBankAccountByAccountNumber(Long accountNumber);

	public List<BankAccountsVO> getLinkedBankAccounts(Long walletId);

	public BankToWalletVO addMoneyToWallet(BankToWalletVO bankToWalletVO);
	
}
