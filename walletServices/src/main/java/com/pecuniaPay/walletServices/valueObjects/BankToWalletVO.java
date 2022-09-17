package com.pecuniaPay.walletServices.valueObjects;

public class BankToWalletVO {
	private Long walletId;
	private Long accountNumber;
	private Long amount;
	public BankToWalletVO(Long walletId, Long accountNumber, Long amount) {
		super();
		this.walletId = walletId;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public BankToWalletVO() {
		super();
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BankToWalletVO [walletId=" + walletId + ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
	
}
