package com.ilp.entity;

import java.util.ArrayList;

public class Product {
	private String productCode;
	private String productName;
	private ArrayList<Services> choiceOfService;
	public Product(String productCode, String productName, ArrayList<Services> choiceOfService) {
		this.productCode = productCode;
		this.productName = productName;
		this.choiceOfService = choiceOfService;
	}
	public String getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public ArrayList<Services> getChoiceOfService() {
		return choiceOfService;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setChoiceOfService(ArrayList<Services> choiceOfService) {
		this.choiceOfService = choiceOfService;
	}
	

	
	

}
