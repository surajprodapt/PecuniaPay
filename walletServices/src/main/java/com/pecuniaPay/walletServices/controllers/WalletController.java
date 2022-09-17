package com.pecuniaPay.walletServices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pecuniaPay.walletServices.entities.BankAccount;
import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.services.BankAccountService;
import com.pecuniaPay.walletServices.services.CustomerWalletService;
import com.pecuniaPay.walletServices.valueObjects.BankAccountsVO;
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
	
	//will make a method to get wallet id by customer id by adding customerId in value object
	//and then getting the wallet id by rest template using the url -: localhost:8060/login/users/getwalletid/{id}
	//Service impl will look like
	//Long walletid = restTemplate.getForObject("localhost:8060/login/users/getwalletid/"+valueObject.getCustomerId(), Long.class);
	//valueObject.setWalletId(walletid);
	
	@PostMapping("/addbankaccount")
	public WalletBankAccountVO addBankAccount(@RequestBody WalletBankAccountVO valueObject)
	{
		return bankAccountService.addBankAccount(valueObject);
	}
	
	@GetMapping("/getlinkedbankaccounts/{id}")
	public List<BankAccountsVO> getLinkedBankAccounts(@PathVariable ("id") Long walletId)
	{
		return bankAccountService.getLinkedBankAccounts(walletId);
	}
	
	@GetMapping("/getwalletbalance/{id}")
	public Long getWalletBalance(@PathVariable ("id") Long walletId)
	{
		return customerWalletService.getWalletBalance(walletId);
	}
}
