package com.pecuniaPay.walletServices.valueObjects;

public class BankAccountsVO {
	private Long accountNumber;
	private String ifscCode;
	private Long bankBalance;
	public BankAccountsVO(Long accountNumber, String ifscCode, Long bankBalance) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankBalance = bankBalance;
	}
	public BankAccountsVO() {
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
	@Override
	public String toString() {
		return "BankAccountsVO [accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", bankBalance="
				+ bankBalance + "]";
	}
	
}
