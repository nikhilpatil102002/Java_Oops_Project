package com.bank.main;

import com.bank.customer.Customer;
import com.bank.account.SavingsAccount;
import com.bank.account.Account;
import com.bank.account.CurrentAccount;
import com.bank.service.Bank;
import java.util.Scanner;

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        
        while (true) {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Apply Interest (Savings Accounts Only)");
            System.out.println("6. Show All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    sc.nextLine();  // Consume the newline
                    String name = sc.nextLine();
                    System.out.print("Enter contact number: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();
                    Customer customer = new Customer(name, contact, address);
                    
                    System.out.print("Enter account number: ");
                    String accNumber = sc.nextLine();
                    
                    System.out.println("Account Type: 1. Savings  2. Current");
                    int accType = sc.nextInt();
                    
                    if (accType == 1) {
                        System.out.print("Enter interest rate (e.g., 0.03 for 3%): ");
                        double interestRate = sc.nextDouble();
                        bank.addAccount(new SavingsAccount(accNumber, customer, interestRate));
                    } else if (accType == 2) {
                        System.out.print("Enter overdraft limit: ");
                        double overdraftLimit = sc.nextDouble();
                        bank.addAccount(new CurrentAccount(accNumber, customer, overdraftLimit));
                    }
                    break;
                
                case 2:
                    System.out.print("Enter account number: ");
                    sc.nextLine();  // Consume the newline
                    String accNoDeposit = sc.nextLine();
                    Account accountDeposit = bank.findAccount(accNoDeposit);
                    if (accountDeposit != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        accountDeposit.deposit(depositAmount);
                    }
                    break;
                
                case 3:
                    System.out.print("Enter account number: ");
                    sc.nextLine();  // Consume the newline
                    String accNoWithdraw = sc.nextLine();
                    Account accountWithdraw = bank.findAccount(accNoWithdraw);
                    if (accountWithdraw != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        accountWithdraw.withdraw(withdrawAmount);
                    }
                    break;
                
                case 4:
                    System.out.print("Enter account number: ");
                    sc.nextLine();  // Consume the newline
                    String accNoBalance = sc.nextLine();
                    Account accountBalance = bank.findAccount(accNoBalance);
                    if (accountBalance != null) {
                        System.out.println("Balance: " + accountBalance.getBalance());
                    }
                    break;
                
                case 5:
                    for (Account acc : bank.getAccounts()) {
                        if (acc instanceof SavingsAccount) {
                            ((SavingsAccount) acc).applyInterest();
                        }
                    }
                    break;
                
                case 6:
                    bank.printAllAccounts();
                    break;
                
                case 7:
                    System.out.println("Exiting the system.");
                    sc.close();
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
