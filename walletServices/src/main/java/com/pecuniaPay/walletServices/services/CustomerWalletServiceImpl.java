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
	private CustomerWalletRepository cwr;
	
	private BankAccountRepository bankAccRepo;

	@Override
	public CustomerWallet generateNewWallet(CustomerWallet cw) {
		cw.setWalletBalance(0l);
		return cwr.save(cw);
	}

	@Override
	public void addBankAccounttoWallet(WalletBankAccountVO vo) {
//		System.out.println(vo);
		CustomerWallet cw = cwr.findById(vo.getWalletId()).get();
//		BankAccount ba = new BankAccount();
//		ba.setIfscCode(vo.getIfscCode());
//		ba.setBankBalance(vo.getBankBalance());
//		ba.setWallet(cw);
//		Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
//		bankAccounts.add(ba);
//		cw.setLinkedBanks(bankAccounts);
//		System.out.println(cw);
//		cwr.save(cw);
//		System.out.println(cw);
		
		BankAccount ba = new BankAccount();
		ba.setWallet(cw);
		ba.setIfscCode(vo.getIfscCode());
		ba.setBankBalance(vo.getBankBalance());
		bankAccRepo.save(ba);
		System.out.println(ba);
	}

//	@Override
//	public CustomerWallet addBankAccounttoWallet(CustomerWallet customerWallet,BankAccount bankAccount) {
//		CustomerWallet cw = cwr.findById(customerWallet.getWalletId()).get();
//		if(Objects.nonNull(customerWallet.getWalletBalance()))
//		{
//			cw.setWalletBalance(customerWallet.getWalletBalance());
//		}
//		if(Objects.nonNull(customerWallet.getLinkedBanks()))
//		{
//			Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
//			bankAccounts.add(bankAccount);
//			cw.setLinkedBanks(bankAccounts);
//		}
//		return cwr.save(cw);
//	}

}
