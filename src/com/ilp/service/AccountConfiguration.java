package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class AccountConfiguration {
	public static Customer createCustomer(ArrayList<Product> productList, ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter customer Code: ");
		String customerCode = scanner.nextLine();

		System.out.println("Enter customer's name: ");
		String customerName = scanner.nextLine();

		
		char accountWanted;
		do {

			accountList.add(createAccount(productList));

			System.out.println("Do you Want to create another Account? (y/n)");
			accountWanted = scanner.next().charAt(0);


		} while (accountWanted == 'y');
		for (Account account : accountList) {
			System.out.println(account.getchoiceOfProduct().getProductName() + " created for " + customerName
					+ " with the following Services");
			for (Services service : account.getchoiceOfProduct().getChoiceOfService()) {
				System.out.println(service.getServiceCode() + " - " + service.getServiceName());
			}
		}
		System.out.println("Account Is Active!!!!!");
		Customer customer = new Customer(customerCode, customerName, accountList);

		return customer;

	}

	public static Account createAccount(ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);


		
		System.out.println("*********Products Available**********");
		for (Product product : productList) {
			System.out.println(product.getProductCode() + " - " + product.getProductName());
		}
		System.out.println("Select a product:");
		String selectedProduct = scanner.nextLine();


		Product choiceOfProduct = null;
		for (Product product : productList) {
			if (selectedProduct.equalsIgnoreCase(product.getProductCode())) {
				choiceOfProduct = product;
			}
		}

		System.out.println("Enter The Account Code: ");
		String accountCode = scanner.nextLine();
		System.out.println("Enter opening balance to be deposited: ");
		double openingBalance;
//		SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) account.getchoiceOfProduct();
//		double minimumBalance = savingsMaxAccount.getMinimumBalance();
		
		if(choiceOfProduct instanceof SavingsMaxAccount) {
			openingBalance = scanner.nextDouble();

			if(openingBalance<1000) {
				while(openingBalance<1000) {
					System.out.println("Enter opening balance of minimum Rs. 1000");
					openingBalance = scanner.nextDouble();

				}
			}
		}
		else {
			openingBalance = scanner.nextDouble();

		}
		Account account = new Account(accountCode, openingBalance, choiceOfProduct);

		return account;
	}

	public static void displayAccount(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("*************************Customer-Account Details****************");
		System.out.println("CustomerId\t\t\tCustomerName\t\t\tAccountType\t\t\tBalance ");
		System.out.println("***************************************************************");
		for (Account account : customer.getAccountList()) {
			System.out.println(customer.getCustomerCode() + "\t\t\t" + customer.getCustomerName() + "\t\t\t"
					+ account.getchoiceOfProduct().getProductName() + "\t\t\t" + account.getAccountBalance());
		}
		for (Account account : customer.getAccountList()) {
			System.out.println("Services for " + account.getchoiceOfProduct().getProductName());
			int counter = 1;
			for (Services service : account.getchoiceOfProduct().getChoiceOfService()) {
				System.out.println(counter + "." + service.getServiceName());
				counter++;
			}
		}

	}

	public static void transactionBill(Customer customer) {
		// TODO Auto-generated method stub
		String customerCode = customer.getCustomerCode();
		if (!(customerCode.equalsIgnoreCase(customer.getCustomerCode()))) {
			System.out.println("Customer not found!!!!!");
		} else {
			System.out.println(customer.getCustomerName() + " has the following accounts");
			for (Account account : customer.getAccountList()) {
				System.out.println(account.getAccountNo() + ". " + account.getchoiceOfProduct().getProductName());
			}

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the account no you want to operate on: ");
			String accountChoice = scanner.nextLine();
			for (Account account : customer.getAccountList()) {
				if (accountChoice.equalsIgnoreCase(account.getAccountNo())) {
					Product product = account.getchoiceOfProduct();
					System.out.println("Choose the Service you want to use");
					for (Services service : product.getChoiceOfService()) {
						System.out.println(service.getServiceCode() + " - " + service.getServiceName());
					}
					System.out.println("Enter the service ID you want to use: ");
					String serviceChoice = scanner.nextLine();
					for (Services service : product.getChoiceOfService()) {
						if (serviceChoice.equalsIgnoreCase(service.getServiceCode())) {
							System.out.println("Rate of service = Rs. " + service.getRate());
							System.out.println("Enter the number of transactions: ");
							double noOfTransactions = scanner.nextDouble();
							System.out.println("Total Cost = Rs." + noOfTransactions * service.getRate());
						}
					}
				}
			}
		}
	}
}
