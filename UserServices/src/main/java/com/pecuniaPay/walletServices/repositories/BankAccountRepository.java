package com.pecuniaPay.walletServices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.walletServices.entities.BankAccount;
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

}
