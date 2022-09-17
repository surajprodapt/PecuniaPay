package com.pecuniaPay.walletServices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.walletServices.entities.BankAccount;
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
	List<BankAccount> findByWallet_WalletId(Long walletId);
}
