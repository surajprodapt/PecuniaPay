package com.pecuniaPay.walletServices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.services.BankAccountService;
import com.pecuniaPay.walletServices.services.CustomerWalletService;
import com.pecuniaPay.walletServices.valueObjects.WalletBankAccountVO;
@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
	private CustomerWalletService customerWalletService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@GetMapping("/generatenewwallet")
	public CustomerWallet generateNewWallet(CustomerWallet customerWallet)
	{
		return customerWalletService.generateNewWallet(customerWallet);
	}
	
	@PostMapping("/addbankaccount")
	public WalletBankAccountVO addBankAccount(@RequestBody WalletBankAccountVO valueObject)
	{
		return bankAccountService.addBankAccount(valueObject);
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
