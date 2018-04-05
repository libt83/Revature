package com.revature.bankingApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The bank ATM that stores its user account info (username and balance) into a txt file
 * and provides functionality for getting info from repository and updating the repository.
 */
public class BankATM {
    private Customer customer;

    private String bankDataConnectionPath;

    /**
     * Constructs a Bank ATM with a customer and connection to the bank's
     * user data.
     *
     * @param bankDataConnectionPath - the connection path to the bank's user data
     */
    public BankATM(String bankDataConnectionPath) {
        this.customer = null;
        this.bankDataConnectionPath = bankDataConnectionPath;
    }

    /**
     * Sets the current Bank ATM customer
     *
     * @param customer the current bank ATM customer
     */
    public void setBankUser(Customer customer) {
        this.customer = customer;
    }

    /**
     * Logs the customer into the system
     *
     * @param customer the customer
     */
    public void login(Customer customer) {
        setBankUser(customer);
        customer.setBalance(getBalance());
        System.out.println(customer.toString());
    }

    /**
     * Creates a new bank account for a customer
     *
     * @param customer the customer
     */
    public void createBankAccount(Customer customer) {
        BufferedWriter writer;
        try {
            // Writes new user data into an empty repository
            if (Files.size(Paths.get(bankDataConnectionPath)) == 0) {
                writer = Files.newBufferedWriter(Paths.get(bankDataConnectionPath));
                writer.write("Username: " + customer.getUserName() + " ");
                writer.write("Password: " + customer.getPassword() + " ");
                writer.write("Balance: $0.00\n");
                writer.close();
            // Writes and appends the user data into a non-empty repository
            }else {
                FileWriter fWriter = new FileWriter(bankDataConnectionPath, true);
                writer = new BufferedWriter(fWriter);
                writer.write("Username: " + customer.getUserName() + " ");
                writer.write("Password: " + customer.getPassword() + " ");
                writer.write("Balance: $0.00\n");
                writer.close();
            }
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Checks to see if customer's username exists in the bank's data
     * repository
     *
     * @param userName the customer's username
     * @return true if the customer's username already exists; false otherwise
     */
    public boolean isInCustomerList(String userName) {
        List<String> customerList = this.getUserNameList();
        return customerList.contains(userName);
    }

    /**
     * Converts the bank data into a stream and filters the stream for all
     * of the customer usernames
     *
     * @return a list of customer usernames stored in the bank's data
     */
    public List<String> getUserNameList() {

        List<String> listOfUsers = new ArrayList<>();

        try(Stream<String> stream = Files.lines(Paths.get(bankDataConnectionPath))) {
            // Filters lines in stream that begin with "U"
            // For each of the filtered lines it then puts them in a list with
            // a substring that starts at the user's name
            List<String> tempList = stream
                                    .filter(line -> line.contains("U"))
                                    .map(line -> line.substring(10))
                                    .collect(Collectors.toList());
            stream.close();

            // Iterates over list of substrings to extract the full username and puts it into a list
            for(String str : tempList) {
                listOfUsers.add(str.substring(0, str.indexOf(' ')));
            }
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfUsers;
    }

    /**
     * Checks to see if password matches to the one in the bank's repository
     *
     * @param password the password being checked
     * @return true if the password matches; false otherwise
     */
    public boolean isValidPassword(String password) {
        String passInSystem = getPassword();
        return passInSystem.equals(password);
    }

    /**
     * Gets the password that corresponds to a specific username
     *
     * @return the customer's password
     */
    public String getPassword() {
        List<String> list = new ArrayList<>();
        String password = "";
        int startIndexOfPassword = ("Username: " + customer.getUserName() + " Password: ").length();
        // Filters stream to get the line with matching username and puts a substring beginning where the password
        // starts into a list.
        try(Stream<String> stream = Files.lines(Paths.get(bankDataConnectionPath))) {
            stream
                    .filter(line -> line.contains(customer.getUserName()))
                    .forEach(line -> list.add(line.substring(startIndexOfPassword)));

            // Gets substring from list and splits remaining tokens by ' ' then gets the password from 
            // the 0 index of the returned array
            String sub = list.get(0);
            String[] splitTokens = sub.split(" ", -1);
            password = splitTokens[0];
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return password;
    }
    
    /**
     * Gets the customer's balance
     *
     * @return the customer's balance
     */
    public Double getBalance() {
        List<String> list = new ArrayList<>();
        String strToStartOfDouble = "Username: " + customer.getUserName()
                + " Password: " + customer.getPassword() + " Balance: $";
        try(Stream<String> stream = Files.lines(Paths.get(bankDataConnectionPath))) {
            // Filters the stream for the line containing the current currentCustomer's username and
            // uses the length of the data entry to get a substring containing only the balance
            stream
                    .filter(line -> line.contains(customer.getUserName()))
                    .forEach(line -> list.add(line.substring(strToStartOfDouble.length())));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return Double.parseDouble(list.get(0));
    }

    /**
     * Allows for the customer to deposit money into their account
     *
     * @param amountToDeposit the amount the customer is depositing
     */
    public void deposit(double amountToDeposit) {
        customer.setBalance(customer.getBalance() + amountToDeposit);
    }

    /**
     * Allows for current customer to withdraw amount from their account
     *
     * @param amountToWithdraw the amount the current customer is withdrawing from account
     */
    public void withdraw(double amountToWithdraw) {
        customer.setBalance(customer.getBalance() - amountToWithdraw);
    }

    /**
     * Checks to see if the customer is able to withdraw the specified amount
     *
     * @param currentBalance the customer's balance
     * @param amountToWithdraw the amount the customer is attempting to withdraw
     * @return true if amount can be withdrawn; false otherwise
     */
    public boolean isAbleToWithdrawAmount(double currentBalance, double amountToWithdraw) {
        if(currentBalance - amountToWithdraw < 0) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * Updates the customer's account balance in the bank's repository
     */
    public void updateBalanceInBankRepository() {
        List<String> replacement = new ArrayList<>();
        DecimalFormat df2 = new DecimalFormat("0.00");
        try {
            Path path = Paths.get(bankDataConnectionPath);
            Stream<String> lines = Files.lines(path);
            lines
                    // Checks for the line with the customer username and then replaces the decimal after the "$" sign with the
                    // Updated balance, it just returns the current line if it does not contain the customer username
                    .map(line -> line.contains(customer.getUserName())
                            ? line.replaceFirst("[0-9]+.[0-9]+", String.valueOf(df2.format(customer.getBalance()))):line)
                    .forEach(line -> replacement.add(line));
            Files.write(path, replacement);
            lines.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the customer account information
     *
     * @return the customer's account information
     */
    public String getCustomerAccountInfo() {
        return customer.toString();
    }
}
