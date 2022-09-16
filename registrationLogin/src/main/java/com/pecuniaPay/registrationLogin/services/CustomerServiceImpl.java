package com.pecuniaPay.registrationLogin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecuniaPay.registrationLogin.entities.Customer;
import com.pecuniaPay.registrationLogin.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Optional<Customer> getCustomerDetailsById(Long id) {
		return customerRepository.findById(id);
	}

}
