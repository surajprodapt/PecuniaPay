package com.pecuniaPay.walletServices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.walletServices.entities.CustomerWallet;
import com.pecuniaPay.walletServices.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	//List<Transaction> findByWallet_WalletId(Long walletId);

	List<Transaction> findByWalletIdOrRecieverWalletId(Long walletId,Long recieverWalletId);
}
