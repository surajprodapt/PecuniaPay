package com.pecuniaPay.walletServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.repositories.BankAccountRepository;
import com.pecuniaPay.walletServices.repositories.CustomerWalletRepository;
import com.pecuniaPay.walletServices.valueObjects.WalletBankAccountVO;
@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private BankAccountRepository bankAccountRepo;
	
	@Autowired
	private CustomerWalletRepository customerWalletRepository;
	
	@Override
	public WalletBankAccountVO addBankAccount(WalletBankAccountVO valueObject) {
		CustomerWallet customerWallet = customerWalletRepository.findById(valueObject.getWalletId()).get();
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankBalance(valueObject.getBankBalance());
		bankAccount.setIfscCode(valueObject.getIfscCode());
		bankAccount.setWallet(customerWallet);
		bankAccountRepo.save(bankAccount);
		return valueObject;
	}

	@Override
	public void deleteBankAccountByAccountNumber(Long accountNumber) {
		bankAccountRepo.deleteById(accountNumber);
	}
	
	
}
