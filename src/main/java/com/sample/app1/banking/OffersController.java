package com.sample.app1.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
@CrossOrigin("http://localhost:4200")
public class OffersController {
	
	@Autowired
	private OffersService service;
	
	@PostMapping
	public Offers save(@RequestBody Offers offers) {
		System.out.println("offer name = " + offers.getOfferName() );
		System.out.println("loan amount =" + offers.getLoanAmount());
		System.out.println("interest rate = "  + offers.getInterestRate());
		System.out.println("int free cash = " + offers.getIntFreeCash());
		System.out.println("pre closure charges = " + offers.getPreclosureCharges());
		System.out.println("annual fee = " + offers.getAnnualFee());
		System.out.println("customer id = " + offers.getCustomerId());
		
		return service.save(offers);
	}
	
}
