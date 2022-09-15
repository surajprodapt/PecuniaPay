package com.pecuniaPay.UserServices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.UserServices.entities.CustomerWallet;
@Repository
public interface CustomerWalletRepository extends CrudRepository<CustomerWallet, Long> {

}
