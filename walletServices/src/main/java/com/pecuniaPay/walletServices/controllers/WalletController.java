package com.pecuniaPay.walletServices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.services.CustomerWalletService;
import com.pecuniaPay.walletServices.valueObjects.WalletBankAccountVO;
@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
	private CustomerWalletService cws;
	
	@GetMapping("/generatenewwallet")
	public CustomerWallet generateNewWallet(CustomerWallet cw)
	{
		return cws.generateNewWallet(cw);
	}
	
	@PostMapping("/addbankaccount")
	public void addBankAccounttoWallet(WalletBankAccountVO vo)
	{
		cws.addBankAccounttoWallet(vo);
	}
//	@PostMapping("/addbankaccount")
//	public BankAccount addBankAccounttoWallet(@RequestBody BankAccount bankAccount)
//	{
//		return cws.addBankAccounttoWallet(bankAccount);
//	}
//	@PostMapping("/addbankaccount")
//	public CustomerWallet addBankAccounttoWallet(@RequestBody CustomerWallet customerWallet,@RequestBody BankAccount bankAccount)
//	{
//		Set<BankAccount> bankAccounts = customerWallet.getLinkedBanks();
//		bankAccounts.add(bankAccount);
//		customerWallet.setLinkedBanks(bankAccounts);
//		return cws.addBankAccounttoWallet(customerWallet,bankAccount);
//	}
}
