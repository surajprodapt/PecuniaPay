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

	@Override
	public CustomerWallet addBankAccounttoWallet(WalletBankAccountVO vo) {
		System.out.println(vo);
		CustomerWallet customerWallet = customerWalletRepo.findById(vo.getWalletId()).get();
		BankAccount bankAccount = new BankAccount();
		bankAccount.setIfscCode(vo.getIfscCode());
		bankAccount.setBankBalance(vo.getBankBalance());
		bankAccount.setWallet(customerWallet);
		Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
		bankAccounts.add(bankAccount);
		customerWallet.setLinkedBanks(bankAccounts);
		customerWallet.setWalletBalance(0l);
		System.out.println(customerWallet);
		
		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.setIfscCode(vo.getIfscCode());
		bankAccount1.setBankBalance(vo.getBankBalance());
		bankAccount1.setWallet(customerWallet);
		bankAccRepo.save(bankAccount);
		
		return customerWalletRepo.save(customerWallet);
//		CustomerWallet customerWallet = customerWalletRepo.findById(vo.getWalletId()).get();
//		BankAccount bankAccount = new BankAccount();
//		bankAccount.setIfscCode(vo.getIfscCode());
//		bankAccount.setBankBalance(vo.getBankBalance());
//		bankAccount.setWallet(customerWallet);
//		return bankAccRepo.save(bankAccount);
	}

//	@Override
//	public CustomerWallet addbankAccountnkAccounttoWallet(CustomerWallet customerWallet,bankAccountnkAccount bankAccountnkAccount) {
//		CustomerWallet customerWallet = customerWalletRepo.findById(customerWallet.getWalletId()).get();
//		if(Objects.nonNull(customerWallet.getWalletbankAccountlance()))
//		{
//			customerWallet.setWalletbankAccountlance(customerWallet.getWalletbankAccountlance());
//		}
//		if(Objects.nonNull(customerWallet.getLinkedbankAccountnks()))
//		{
//			Set<bankAccountnkAccount> bankAccountnkAccounts = new HashSet<bankAccountnkAccount>();
//			bankAccountnkAccounts.add(bankAccountnkAccount);
//			customerWallet.setLinkedbankAccountnks(bankAccountnkAccounts);
//		}
//		return customerWalletRepo.save(customerWallet);
//	}

}
