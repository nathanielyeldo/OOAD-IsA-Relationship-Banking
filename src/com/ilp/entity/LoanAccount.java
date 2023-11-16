package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	private double checkDeposit = 0.3;
	public double getCheckDeposit() {
		return checkDeposit;
	}
	public void setCheckDeposit(double checkDeposit) {
		this.checkDeposit = checkDeposit;
	}
	public LoanAccount(String productCode, String productName, ArrayList<Services> choiceOfService) {
		super(productCode, productName, choiceOfService);
		// TODO Auto-generated constructor stub
	}

}
