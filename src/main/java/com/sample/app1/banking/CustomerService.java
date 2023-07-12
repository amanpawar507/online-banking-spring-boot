package com.sample.app1.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	
	public Customer findById(Long customerId) {
		return repo.findById(customerId).get();
	}
	
}
