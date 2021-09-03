package com.mahendra.models;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {

	private String accHolderName;
	private Double balance;
	private String accNumber;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
		
	public Account(String accHolderName, Double balance, String accNumber) {
		super();
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.accNumber = accNumber;
	}




	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	
	
}
