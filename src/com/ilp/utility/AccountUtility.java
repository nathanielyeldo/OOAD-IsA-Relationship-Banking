package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.AccountConfiguration;
import com.ilp.service.ManageAccountService;
import com.ilp.service.ProductConfiguration;

public class AccountUtility {

	public static void main(String[] args) {
		Customer customer = null;
		ArrayList<Services> serviceList = new ArrayList<Services>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Account> accountList = new ArrayList<Account>();

		Scanner scanner = new Scanner(System.in);
		char goToMainMenu;
		do {
			System.out.println("******Welcome To Bank*******");
			System.out.println("1.Create Services");
			System.out.println("2.Create Products");
			System.out.println("3.Create Accounts");
			System.out.println("4. Manage Accounts");
			System.out.println("5.Display Accounts");
			System.out.println("6.Transaction Bill");
			System.out.println("7. Exit");
			System.out.println("Enter Your Choice:");

			int mainMenuChoice = scanner.nextInt();

			switch (mainMenuChoice) {
			case 1:
				serviceList = ProductConfiguration.createServices();
				break;
			case 2:
				productList = ProductConfiguration.createProduct(serviceList);
				break;
			case 3:
				customer = AccountConfiguration.createCustomer(productList, accountList);
				break;
			case 4:
				ManageAccountService.manageAccount(customer);
				break;
			case 5:
				AccountConfiguration.displayAccount(customer);
				break;
			case 6:
				AccountConfiguration.transactionBill(customer);
				break;
			case 7: 
				System.exit(0);
				break;
			}
			System.out.println("Go back to main menu (y/n)");
			goToMainMenu = scanner.next().charAt(0);
		} while (goToMainMenu == 'y');
	}
}
