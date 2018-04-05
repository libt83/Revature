package com.revature.bankingApp;

import java.text.DecimalFormat;

/**
 * Creates a customer that contains its username and balance
 */
public class Customer {
    private String userName;

    private String password;

    private double balance;

    Customer() {
        this.userName = "";
        this.password = "";
        this.balance = 0.00;
    }

    /**
     * Gets the customer's username
     *
     * @return the customer's username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the customer's username
     *
     * @param userName sets the customer's username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the customer's password
     *
     * @return customer's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the customer's password
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the customer's balance
     *
     * @return the customer's balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the customer's balance
     *
     * @param balance the customer's modified balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * String representation of the customer's info (username and balance)
     *
     * @return string containing the customer's username and balance
     */
    @Override
    public String toString() {
        DecimalFormat df2 = new DecimalFormat("0.00");
        return "Username: " + userName + "\n" + "Balance: $" + df2.format(balance) + "\n";
    }
}
