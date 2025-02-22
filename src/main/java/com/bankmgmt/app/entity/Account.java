package com.bankmgmt.app.entity;

public class Account {
    private Integer id;
    private String accountHolderName;
    private String accountType;
    private Double balance;
    private String email;

    // Constructors, getters, and setters

    public Account(Integer id, String accountHolderName, String accountType, Double balance, String email) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }
// TODO: Add getters and setters


    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
