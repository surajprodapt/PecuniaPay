package com.pecuniaPay.walletServices.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerWallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long walletId;
	private Long walletBalance;
	@OneToMany(mappedBy = "wallet")
	private Set<BankAccount> linkedBanks;
	public CustomerWallet(Long walletId, Long walletBalance, Set<BankAccount> linkedBanks) {
		super();
		this.walletId = walletId;
		this.walletBalance = walletBalance;
		this.linkedBanks = linkedBanks;
	}
	public CustomerWallet() {
		super();
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public Long getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(Long walletBalance) {
		this.walletBalance = walletBalance;
	}
	public Set<BankAccount> getLinkedBanks() {
		return linkedBanks;
	}
	public void setLinkedBanks(Set<BankAccount> linkedBanks) {
		this.linkedBanks = linkedBanks;
	}
	@Override
	public String toString() {
		return "CustomerWallet [walletId=" + walletId + ", walletBalance=" + walletBalance + ", linkedBanks="
				+ linkedBanks + "]";
	}
	
}
