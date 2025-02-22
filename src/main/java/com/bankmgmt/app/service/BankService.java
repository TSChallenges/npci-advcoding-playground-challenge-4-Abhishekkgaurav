package com.bankmgmt.app.service;

import com.bankmgmt.app.entity.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bankmgmt.app.entity.Account;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.*;

@Service
public class BankService {

    private List<Account> accounts = new ArrayList<>();
    private Integer currentId = 1;

    // TODO: Method to Create a new Account

    public Account createAccount(String accountHolderName, String accountType, String email) {

        Account account = new Account(currentId++, accountHolderName, accountType, 0.0, email);
        for (Account existingAccount : accounts) {
            if (existingAccount.getEmail().equalsIgnoreCase(account.getEmail())) {
                currentId--;
                throw new IllegalArgumentException("Email already in use.");
            }
        }
        if (!account.getAccountType().equalsIgnoreCase("SAVINGS") &&
                !account.getAccountType().equalsIgnoreCase("CURRENT")) {
            currentId--;
            throw new IllegalArgumentException("Invalid account type. Must be SAVINGS or CURRENT.");
        }
        accounts.add(account);
        return account;
    }


    // TODO: Method to Get All Accounts
    public List<Account> getAllAccounts() {
        return accounts;
    }



    // TODO: Method to Get Account by ID

    public Optional<Account> getAccountById(int id) {
        return accounts.stream().filter(a -> a.getId() == id).findFirst();
    }



    // TODO: Method to Deposit Money to the specified account id

    public boolean deposit(int id, double amount) {
        if (amount <= 0) return false;
        Optional<Account> accountOpt = getAccountById(id);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            account.setBalance(account.getBalance() + amount);
            return true;
        }
        return false;
    }


    // TODO: Method to Withdraw Money from the specified account id
    public boolean withdraw(int id, double amount) {
        if (amount <= 0) return false;
        Optional<Account> accountOpt = getAccountById(id);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                return true;
            }
        }
        return false;
    }


    // TODO: Method to Transfer Money from one account to another

    public boolean transfer(int fromId, int toId, double amount) {
        if (amount <= 0) return false;
        Optional<Account> fromAccountOpt = getAccountById(fromId);
        Optional<Account> toAccountOpt = getAccountById(toId);

        if (fromAccountOpt.isPresent() && toAccountOpt.isPresent()) {
            Account fromAccount = fromAccountOpt.get();
            Account toAccount = toAccountOpt.get();
            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                return true;
            }
        }
        return false;
    }



    // TODO: Method to Delete Account given a account id
    public boolean deleteAccount(int id) {
        return accounts.removeIf(account -> account.getId() == id);
    }

}
