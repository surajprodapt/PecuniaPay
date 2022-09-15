package com.pecuniaPay.walletServices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.walletServices.entities.CustomerWallet;
@Repository
public interface CustomerWalletRepository extends CrudRepository<CustomerWallet, Long> {

}
