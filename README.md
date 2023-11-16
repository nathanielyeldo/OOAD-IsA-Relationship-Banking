# OOAD-IsA-Relationship-Banking
## Class Diagram
![image](https://github.com/nathanielyeldo/OOAD-IsA-Relationship-Banking/assets/56597570/619be344-2a05-4768-9ff5-0e3d8f8f0736)

### Domain: Banking

Use case : When a customer attempts to deposit money, the list of all accounts which the customers possess should be listed so that the customer can select to which account he would like to deposit the money.[Hint: Customer has Accounts] . Customer can have the following accounts

SavingsMaxAccount

CurrentAccount

LoanAccount

- Customer(customerCode,customerName,List<Account>)

- Account(accountNo,accountType,balance,Product).

- Product(productCode,productName,List<Service>)

- SavingsMaxAccount is a Product(minimumBalance of Rs1000 should be maintained in the account)

- CurrentAccount is a Product

- LoanAccount is a Product.(chequeDeposit should be chargeable ie).3%).

- Service(serviceCode,serviceName,rate)

He should be given default services like

SavingsMaxAccount(CashDeposit. ATMWithdrawl,OnlineBanking)

CurrentAccount(CashDeposit,OnlineBanking,ATMWithdrawl,MobileBanking)

LoanAccount(CashDeposit,ChequeDeposit)
