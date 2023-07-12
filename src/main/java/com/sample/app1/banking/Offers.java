package com.sample.app1.banking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "offer_id")
	private Integer offerId;
	private String offerName;
	private int loanAmount;
	private int interestRate;
	private int intFreeCash;
	private int annualFee;
	private int preclosureCharges;
	@Column(name="customer_id")
	private Long customerId;
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offers(Integer offerId, String offerName, int loanAmount, int interestRate, int intFreeCash, int annualFee,
			int preclosureCharges, Long customerId) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.intFreeCash = intFreeCash;
		this.annualFee = annualFee;
		this.preclosureCharges = preclosureCharges;
		this.customerId = customerId;
	}
	public Integer getOfferId() {
		return offerId;
	}
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	public int getIntFreeCash() {
		return intFreeCash;
	}
	public void setIntFreeCash(int intFreeCash) {
		this.intFreeCash = intFreeCash;
	}
	public int getAnnualFee() {
		return annualFee;
	}
	public void setAnnualFee(int annualFee) {
		this.annualFee = annualFee;
	}
	public int getPreclosureCharges() {
		return preclosureCharges;
	}
	public void setPreclosureCharges(int preclosureCharges) {
		this.preclosureCharges = preclosureCharges;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}