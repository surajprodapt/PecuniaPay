package com.pecuniaPay.walletServices.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private LocalDateTime transactionDateTime;
	private Long amount;
	private String description;
	private Long walletId;
	private Long recieverWalletId;
	public Transaction(Long transactionId, LocalDateTime transactionDateTime, Long amount, String description,
			Long walletId, Long recieverWalletId) {
		super();
		this.transactionId = transactionId;
		this.transactionDateTime = transactionDateTime;
		this.amount = amount;
		this.description = description;
		this.walletId = walletId;
		this.recieverWalletId = recieverWalletId;
	}
	public Transaction() {
		super();
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public Long getRecieverWalletId() {
		return recieverWalletId;
	}
	public void setSendersWalletId(Long recieverWalletId) {
		this.recieverWalletId = recieverWalletId;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDateTime=" + transactionDateTime
				+ ", amount=" + amount + ", description=" + description + ", walletId=" + walletId
				+ ", recieverWalletId=" + recieverWalletId + "]";
	}
	
	
}
