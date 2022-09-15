package com.pecuniaPay.UserServices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pecuniaPay.UserServices.entities.CustomerWallet;
import com.pecuniaPay.UserServices.repositories.CustomerWalletRepository;
@RestController
public class WalletController {

	@Autowired
	private CustomerWalletRepository cwRepo;
	
	@GetMapping("/generatenewwallet")
	public CustomerWallet generateNewWallet(CustomerWallet cw)
	{
		cw.setWalletBalance(0l);
		return cwRepo.save(cw);
	}
}
