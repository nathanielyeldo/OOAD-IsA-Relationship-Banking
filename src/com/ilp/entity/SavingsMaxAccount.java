package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	private double minimumBalance = 1000;
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> choiceOfService) {
		super(productCode, productName, choiceOfService);
		// TODO Auto-generated constructor stub
	}

}
