package com.ilp.entity;

public class Account {
	//member variables
	private String accountNo;
	private double accountBalance;
	private Product choiceOfProduct;
	//called implicitly
	
	public Account(String accountNo, double accountBalance, Product choiceOfProduct) {
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.choiceOfProduct = choiceOfProduct;
	}

	public String  getAccountNo()  {
		return accountNo;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	
	public Product getchoiceOfProduct() {
		return choiceOfProduct;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setchoiceOfProduct(Product choiceOfProduct) {
		this.choiceOfProduct = choiceOfProduct;
	}
	
	



}
