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
import com.pecuniaPay.walletServices.valueObjects.BankToWalletVO;
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
		bankAccount.setBankBalance(5000l);
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

	@Override
	public BankToWalletVO addMoneyToWallet(BankToWalletVO bankToWalletVO) {
		BankAccount bankAccount = bankAccountRepo.findById(bankToWalletVO.getAccountNumber()).get();
		if(bankAccount.getBankBalance()<bankToWalletVO.getAmount())
		{
			System.out.println("Not sufficient Bank Balance");
		}
		else
		{
			CustomerWallet customerWallet = customerWalletRepository.findById(bankToWalletVO.getWalletId()).get();
			bankAccount.setBankBalance(bankAccount.getBankBalance()-bankToWalletVO.getAmount());
			customerWallet.setWalletBalance(customerWallet.getWalletBalance()+bankToWalletVO.getAmount());
			bankAccountRepo.save(bankAccount);
			customerWalletRepository.save(customerWallet);
		}
		return bankToWalletVO;
	}
	
	
}
