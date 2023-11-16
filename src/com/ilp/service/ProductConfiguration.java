package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class ProductConfiguration {
	static ArrayList<Product> productList = new ArrayList<Product>();
	static ArrayList<Services> servicesList = new ArrayList<Services>();

	public static ArrayList<Product> createProduct(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		char serviceChoice;
		char productChoice;

		do {
			ArrayList<Services> choiceOfService = new ArrayList<Services>();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter product code");
			String productCode = scanner.nextLine();
			


			System.out.println("Enter product name");
			String productName = scanner.nextLine();
			

			do {
				System.out.println("*******Select the services*******");
				for (Services service : serviceList) {
					System.out.println(service.getServiceCode() + " - " + service.getServiceName());
				}
				String selectedService = scanner.nextLine();
				
				
				for (Services service : serviceList) {
					if (selectedService.equals(service.getServiceCode())) {
						choiceOfService.add(service);
					}
				}
				System.out.println("Do you want to add another service(y/n)?");
				serviceChoice = scanner.next().charAt(0);
				

				

			} while (serviceChoice == 'y');
			
			
			Product product = null;
			if(productName.equalsIgnoreCase("Savings Max Account")) {
				product = new SavingsMaxAccount(productCode, productName, choiceOfService);
			}
			else if(productName.equalsIgnoreCase("Current Account"))
			{
				product = new CurrentAccount(productCode, productName, choiceOfService);

			}
			else if(productName.equalsIgnoreCase("Loan Account")){
				product = new LoanAccount(productCode, productName, choiceOfService);

			}
			
			productList.add(product);
			System.out.println("Do you want to add another product(y/n)?");
			productChoice = scanner.next().charAt(0);
			scanner.nextLine();

		} while (productChoice == 'y');
		return productList;
	}



	public static ArrayList<Services> createServices() {
		char serviceChoice;

		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter service code");
			String serviceCode = scanner.nextLine();

			System.out.println("Enter service name");
			String serviceName = scanner.nextLine();

			System.out.println("Enter service rate");
			double serviceRate = scanner.nextDouble();

			Services services = new Services(serviceCode, serviceName, serviceRate);
			servicesList.add(services);
			System.out.println("Do you want to add another service(y/n)?");
			serviceChoice = scanner.next().charAt(0);

		} while (serviceChoice == 'y');
		return servicesList;
	}


}
