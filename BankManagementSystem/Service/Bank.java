package com.bank.service;

import com.bank.account.Account;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        setAccounts(new ArrayList<>());
    }

    public void addAccount(Account account) {
        getAccounts().add(account);
        System.out.println("Account created successfully.");
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : getAccounts()) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    public void printAllAccounts() {
        for (Account acc : getAccounts()) {
            System.out.println(acc);
        }
    }

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
