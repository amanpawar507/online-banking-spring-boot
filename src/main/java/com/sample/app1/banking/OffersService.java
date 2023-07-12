package com.sample.app1.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffersService {
	@Autowired
	private OffersRepo repo;
	
	public Offers save(Offers offers) {
		return repo.save(offers);
	}

}
