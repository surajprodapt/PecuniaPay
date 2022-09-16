package com.pecuniaPay.walletServices.valueObjects;

public class WalletBankAccountVO {
	private Long walletId;
	private String ifscCode;
	private Long bankBalance;
	public WalletBankAccountVO(Long walletId, String ifscCode, Long bankBalance) {
		super();
		this.walletId = walletId;
		this.ifscCode = ifscCode;
		this.bankBalance = bankBalance;
	}
	public WalletBankAccountVO() {
		super();
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
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
		return "WalletBankAccountVO [walletId=" + walletId + ", ifscCode=" + ifscCode + ", bankBalance=" + bankBalance
				+ "]";
	}
	
}
