package com.pecuniaPay.UserServices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.UserServices.entities.BankAccount;
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

}
