package com.ilp.service;

import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;

public class ManageAccountService {

	public static void manageAccount(Customer customer) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Customer Code:");
		String customerChoice = scanner.nextLine();


		if (!(customerChoice.equalsIgnoreCase(customer.getCustomerCode()))) {
			System.out.println("Invalid Customer");
		} else {
			System.out.println(customer.getCustomerName() + " has the following accounts:");
			for (Account account : customer.getAccountList()) {
				System.out.println(account.getAccountNo() + " - " + account.getchoiceOfProduct().getProductName());
			}

			System.out.println("Select the account you want to manage: ");
			String accountChoice = scanner.nextLine();


			for (Account account : customer.getAccountList()) {
				if (accountChoice.equalsIgnoreCase(account.getAccountNo())) {
					System.out.println("How do you want to manage the account: ");
					System.out.println("1. Deposit  2. Withdrawal  3. Display Balance");
					int manageChoice = scanner.nextInt();

					if (manageChoice == 1)
						depositMoney(account);
					else if (manageChoice == 2)
						withdrawMoney(account);
					else if (manageChoice == 3)
						displayBalance(account);
				}
			}

		}
	}

	private static void displayBalance(Account account) {
		// TODO Auto-generated method stub
		System.out.println("The Account Balance of "+account.getchoiceOfProduct().getProductName()+" is "+account.getAccountBalance());

	}

	private static void withdrawMoney(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double withdrawAmount;
		
		if (account.getchoiceOfProduct() instanceof SavingsMaxAccount) {
			SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) account.getchoiceOfProduct();
			double minimumBalance = savingsMaxAccount.getMinimumBalance();
			System.out.println("Enter the withdrawal amount: ");
			withdrawAmount = scanner.nextDouble();
			scanner.nextLine();

			if ((account.getAccountBalance() - withdrawAmount) < minimumBalance) {
				while ((account.getAccountBalance() - withdrawAmount) < minimumBalance) {
					System.out.println("Minimum Balance of Rs. "+minimumBalance+" should be maintained");
					System.out.println("Enter an lesser amount: ");
					withdrawAmount = scanner.nextDouble();
					scanner.nextLine();

				}
			}
			account.setAccountBalance(account.getAccountBalance()-withdrawAmount);
		}
		else {
			System.out.println("Enter the withdrawal amount: ");
			withdrawAmount = scanner.nextDouble();
			scanner.nextLine();

			account.setAccountBalance(account.getAccountBalance()-withdrawAmount);
		}

	}

	private static void depositMoney(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double depositAmount;
		if (account.getchoiceOfProduct() instanceof LoanAccount) {
			System.out.println("Enter the type of deposit:");
			System.out.println("1. Over the counter  2. Cheque Deposit");
			int depositType = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter the deposit amount: ");
			depositAmount = scanner.nextDouble();
			scanner.nextLine();
			LoanAccount loanAccount = (LoanAccount) account.getchoiceOfProduct();
			double chequeDeposit = loanAccount.getCheckDeposit();

			if (depositType == 1) {
				account.setAccountBalance(account.getAccountBalance() + depositAmount);
			} else if (depositType == 2) {
				double totalBalance = account.getAccountBalance() + depositAmount;
				account.setAccountBalance(totalBalance - (totalBalance *chequeDeposit ));
			} else {
				System.out.println("Wrong Choice!!!!");
			}

		} else {
			System.out.println("Enter the deposit amount: ");
			depositAmount = scanner.nextDouble();
			scanner.nextLine();

			account.setAccountBalance(account.getAccountBalance() + depositAmount);
		}
	}

}
