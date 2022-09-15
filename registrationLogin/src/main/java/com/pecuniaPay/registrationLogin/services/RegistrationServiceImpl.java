package com.pecuniaPay.registrationLogin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pecuniaPay.registrationLogin.entities.Customer;
import com.pecuniaPay.registrationLogin.entities.Registration;
import com.pecuniaPay.registrationLogin.exceptions.RegistrationClassNotFound;
import com.pecuniaPay.registrationLogin.repositories.RegistrationRepository;
import com.pecuniaPay.registrationLogin.valueObjects.CustomerWallet;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Registration saveNewUser(Registration userDetails) {
		//userDetails.setWalletBalance(0);
		CustomerWallet cw = restTemplate.getForObject("http://localhost:8084/generatenewwallet", CustomerWallet.class);
		Customer cust = new Customer();
		cust.setFirstName(userDetails.getFirstName());
		cust.setLastName(userDetails.getLastName());
		cust.setMobileNumber(userDetails.getMobileNumber());
		cust.setEmail(userDetails.getEmailId());
//		cust.setWalletId(null);
		cust.setWalletId(cw.getWalletId());
		userDetails.setCustomer(cust);
		return registrationRepo.save(userDetails);
	}

	@Override
	public Optional<Registration> getUserDetailsById(Long id) throws RegistrationClassNotFound {
		return registrationRepo.findById(id);
	}

}
