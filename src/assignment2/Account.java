package assignment2;

import java.io.Serializable;

public class Account implements Serializable {

    private int accountNumber;
    private Customer customer;
    protected double balance = 500;

    public Account() {
    }

    public Account(Customer customer) {
        this.accountNumber = customer.getId();
        this.customer = customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
