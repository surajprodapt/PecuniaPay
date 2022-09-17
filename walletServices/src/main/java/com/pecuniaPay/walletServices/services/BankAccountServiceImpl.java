package com.pecuniaPay.walletServices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.repositories.BankAccountRepository;
import com.pecuniaPay.walletServices.repositories.CustomerWalletRepository;
import com.pecuniaPay.walletServices.valueObjects.BankAccountsVO;
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

	@Override
	public List<BankAccountsVO> getLinkedBankAccounts(Long walletId) {
		List<BankAccount> bankAccounts = bankAccountRepo.findByWallet_WalletId(walletId);
		List<BankAccountsVO> linkedBankAccounts = new ArrayList<BankAccountsVO>();
		int totalBankAccounts = bankAccounts.size();
		for(int i=0;i<totalBankAccounts;i++)
		{
			BankAccount bankAccount = bankAccounts.get(i);
			BankAccountsVO bankAccountVo = new BankAccountsVO();
			bankAccountVo.setAccountNumber(bankAccount.getAccountNumber());
			bankAccountVo.setBankBalance(bankAccount.getBankBalance());
			bankAccountVo.setIfscCode(bankAccount.getIfscCode());
			linkedBankAccounts.add(bankAccountVo);
		}
		return linkedBankAccounts;
	}
	
	
}
