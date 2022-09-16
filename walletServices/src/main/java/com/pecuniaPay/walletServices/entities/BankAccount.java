package com.pecuniaPay.walletServices.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;
	private String ifscCode;
	private Long bankBalance;
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerWallet wallet;
	public BankAccount(Long accountNumber, String ifscCode, Long bankBalance, CustomerWallet wallet) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankBalance = bankBalance;
		this.wallet = wallet;
	}
	public BankAccount() {
		super();
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public Long getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(Long bankBalance) {
		this.bankBalance = bankBalance;
	}
	public CustomerWallet getWallet() {
		return wallet;
	}
	public void setWallet(CustomerWallet wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", bankBalance=" + bankBalance
				+ "]";
	}
	
}
