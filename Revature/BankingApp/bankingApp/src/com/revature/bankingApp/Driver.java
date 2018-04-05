package com.revature.bankingApp;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * @author Brandon Semba
 *
 * The driver for the class. It handles all the input validation, console displaying, and
 * menu navigation for the console application
 */
public class Driver {
    /**
     * Generates the home screen
     */
    private static void generateMainMenu() {
        System.out.println("<---------------------------------------------->");
        System.out.println("|                   Welcome                    |");
        System.out.println("|                 Semba Bank                   |");
        System.out.println("|                                              |");
        System.out.println("|         Enter '1' to login to Account        |");
        System.out.println("|         Enter '2' to Create an Account       |");
        System.out.println("|______________________________________________|");
    }

    /**
     * Generates the user menu
     */
    private static void generateUserMenu() {
        System.out.println("<---------------------------------------------->");
        System.out.println("|   Enter '1' to view account balance          |");
        System.out.println("|   Enter '2' to deposit money into account    |");
        System.out.println("|   Enter '3' to withdraw money from account   |");
        System.out.println("|______________________________________________|");
    }

    /**
     * Generates invalid dollar input message.
     * Used for avoiding redundant code
     */
    private static void generateInvalidDollarAmountMessage() {
        System.out.println();
        System.out.println("You have not entered a valid dollar amount in decimal format - Please try again");
        System.out.print("Re-enter dollar amount in decimal format: $");
    }

    /**
     * Generates invalid password message
     * Used for avoiding redundant code
     */
    private static void generateInvalidPasswordMessage() {
        System.out.println();
        System.out.println("Invalid password - Please try again");
        System.out.print("Please re-enter your password: ");
    }
    
    /**
     * Checks for valid home screen option.
     *
     * @param userChoice the user input
     * @return true if 1 or 2 was detected; false otherwise
     */
    private static boolean isValidStartMenuOption(String userChoice) {
        if(userChoice.equals("1") || (userChoice.equals("2"))) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * Checks to see if user input a valid user menu option
     *
     * @param userChoice the user input
     * @return true if the user input 1, 2, or 3; false otherwise
     */
    private static boolean isValidMenuOption(String userChoice) {
        char firstChar = userChoice.charAt(0);
        if (userChoice.length() > 1) {
            return false;
        }else if (!Character.isDigit(firstChar)) {
            return false;
        }else if (firstChar != '1' && firstChar != '2' && firstChar != '3') {
            return false;
        }else {
            return true;
        }
    }

    /**
     * Checks to see if the user enters a valid option for going to a previous screen
     * or for exiting the program
     *
     * @param userChoice the user input
     * @return true if the user input exit or prev; false otherwise
     */
    private static boolean isPrevOrExit(String userChoice) {
        if(userChoice.equals("exit") || (userChoice.equals("prev"))) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * Checks to see if string is in dollar decimal format (0.00)
     *
     * @param doubleString the amount as a string
     * @return true if it is in the valid format; false otherwise
     */
    private static boolean isDouble(String doubleString) {
        int decimalIndex = doubleString.indexOf('.');
        // Checks if the decimal is present and that the whole number doesn't begin with zero
        if(decimalIndex == -1 || (doubleString.charAt(0) == '0')) {
            return false;
        // Checks to see if the ending substring after the decimal is of the format .00
        }else if(doubleString.substring(decimalIndex + 1).length() < 2 
        		|| doubleString.substring(decimalIndex + 1).length() > 2) {
            return false;
        // Checks to ensure the two decimal places contains only digits
        }else if(!Character.isDigit(doubleString.charAt(doubleString.length() - 1))
                || (!Character.isDigit(doubleString.charAt(doubleString.length() - 2)))) {
            return false;
        // Checks to see if the whole number value contains only digits
        }else {
            char[] wholeNumberChars = doubleString.substring(0, decimalIndex).toCharArray();
            if(wholeNumberChars.length < 1) {
                return false;
            }

            for(char ch : wholeNumberChars) {
                if(!Character.isDigit(ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String connectionToBank = "accounts.txt";
        BankATM atm = new BankATM(connectionToBank);
        Customer currentCustomer = new Customer();
        atm.setBankUser(currentCustomer);

        Scanner scan = new Scanner(in);
        Driver.generateMainMenu();
        System.out.print("Enter option: ");
        String input = scan.next().trim();

        // Validates home screen menu options
        while(!Driver.isValidStartMenuOption(input)) {
            System.out.println();
            System.out.println("Invalid option entered - Try again");
            Driver.generateMainMenu();
            System.out.print("Enter option: ");
            input = scan.next().trim();
        }

        char firstChar = input.charAt(0);
        // Switch for taking the existing user branch or the new user branch
        switch(firstChar) {
            case '1':
                System.out.println();
                System.out.print("Please enter your unique username: ");
                String userName = scan.next().trim().toLowerCase();

                // Checks to see if user already exists in system
                while(!atm.isInCustomerList(userName)) {
                    System.out.println();
                    System.out.println("You have entered an invalid username.");
                    System.out.print("Please re-enter your username: ");
                    userName = scan.next().trim().toLowerCase();
                }

                currentCustomer.setUserName(userName);

                System.out.print("Please enter your password: ");
                String attemptedPass = scan.next();
                // Checks to see if password is valid
                while(!atm.isValidPassword(attemptedPass)) {
                    Driver.generateInvalidPasswordMessage();
                    attemptedPass = scan.next().trim().toLowerCase();
                }

                currentCustomer.setPassword(attemptedPass);
                atm.login(currentCustomer);

                System.out.println();
                System.out.println("You have successfully logged in " + currentCustomer.getUserName());
                System.out.println("Now enter one of the options from the menu");
                break;
            case '2':
                System.out.println();
                System.out.println("You have selected account creation");
                System.out.println("You must first create a unique username");
                System.out.println();
                System.out.println("Rules for username are the following:");
                System.out.println("Must be 5-8 characters in length");
                System.out.println("Can be any combination of letters and numbers");
                System.out.println();
                System.out.println("Usernames are not case-sensitive");
                System.out.println();
                System.out.print("Please enter your username: ");
                userName = scan.next().trim().toLowerCase();
                boolean validInput = false;

                // Input validation for creating usernames
                while(!validInput) {
                    // Checks to see if username is 5-8 characters long
                    if(userName.length() < 5 || userName.length() > 8) {
                        System.out.println();
                        System.out.println("You've entered an invalid username");
                        System.out.println("Please re-enter a username that is 5-8 characters");
                        System.out.print("Enter username: ");
                        userName = scan.next().trim().toLowerCase();
                    // Checks to see if username is made up of alphanumeric characters (is allowed to contain all alpha or all numeric)
                    }else if(!userName.matches("[a-z0-9]+")) {
                        System.out.println();
                        System.out.println("You've entered an invalid username");
                        System.out.println("Please re-enter a username that is a combination of letters and numbers");
                        System.out.print("Enter username: ");
                        userName = scan.next().trim().toLowerCase();

                    // Checks to see if username is already taken
                    }else if(atm.isInCustomerList(userName)) {
                        System.out.println();
                        System.out.println("You've entered an invalid username");
                        System.out.println("The username you have entered is already taken");
                        System.out.print("Enter username: ");
                        userName = scan.next().trim().toLowerCase();
                    }else {
                        validInput = true;
                    }
                }

                System.out.println("Congrats, you've successfully created a username for your account");
                System.out.println();
                System.out.println("You must now create a password for this account");
                System.out.println("Rules for password creation are as follows:");
                System.out.println();
                System.out.println("Password must be 5 to 8 characters in length");
                System.out.println("Password may contain any combination of letters and numbers");
                System.out.println("Passwords are not case-sensitive");
                System.out.print("Enter your password: ");
                String pass = scan.next();

                // Checks to determine if password is between 5-8 characters and contains only letters and/or numbers
                boolean valid = false;

                // Input validation for creating username
                while(!valid) {
                    // Checks to see if password is 5-8 characters long
                    if (pass.length() < 5 || pass.length() > 8) {
                        System.out.println();
                        System.out.println("You've entered an invalid password");
                        System.out.println("Please re-enter a password that is 5-8 characters");
                        System.out.print("Enter password: ");
                        pass = scan.next().trim().toLowerCase();
                        // Checks to see if password is made up of any combination of letters and numbers
                    }else if(!pass.matches("[a-z0-9]+")) {
                        System.out.println();
                        System.out.println("You've entered an invalid password");
                        System.out.println("Please re-enter a password that is a combination of letters and numbers");
                        System.out.print("Enter password: ");
                        pass = scan.next().trim().toLowerCase();
                    }else {
                        valid = true;
                    }
                }

                currentCustomer.setUserName(userName);
                currentCustomer.setPassword(pass);
                atm.createBankAccount(currentCustomer);

                System.out.println();
                System.out.println("Congratulations you have successfully created an account");
                System.out.println("Please enter your newly created username and password to login into the user menu");
                System.out.print("Enter username: ");
                // Validates that the new user is logging in with their newly created username
                while(!scan.next().trim().equals(currentCustomer.getUserName())) {
                    System.out.println();
                    System.out.println("Invalid username, please try again");
                    System.out.print("Enter username: ");
                }

                System.out.print("Enter password: ");
                String attempted = scan.next().trim().toLowerCase();
                // Checks to see if password exists in the system
                while(!atm.isValidPassword(attempted)) {
                    System.out.println();
                    System.out.println("Invalid password - Please try again");
                    System.out.print("Please re-enter your password: ");
                    attempted = scan.next().trim().toLowerCase();
                }

                atm.login(currentCustomer);
                System.out.println();
                System.out.println("You have successfully logged in " + currentCustomer.getUserName());
                System.out.println("Now enter one of the options from the menu");
        }

        // Handles all of the user menu display, navigation, and validation
        prev:
        while(true) {
            Driver.generateUserMenu();
            System.out.print("Enter option: ");
            String userChoice = scan.next().trim();

            // Checks to see if the user entered a valid user menu option (1, 2, or 3)
            while(!Driver.isValidMenuOption(userChoice)) {
                System.out.println();
                System.out.println("Invalid choice, please choose from the following options");
                Driver.generateUserMenu();
                System.out.print("Enter option: ");
                userChoice = scan.next().trim();
                System.out.println();
            }

            DecimalFormat df2 = new DecimalFormat("0.00");
            // Each case is tied to a particular user menu option and each case contains the logic to perform the
            // desired task
            switch (userChoice.charAt(0)) {
                // Allows user to view account information
                case '1':
                    System.out.println();
                    System.out.println(atm.getCustomerAccountInfo());
                    break;
                // Allows for the user to make deposits into their account
                case '2':
                    System.out.println();
                    System.out.print("Enter the amount to deposit in decimal format: $");
                    String depositValue = scan.next();

                    while(!Driver.isDouble(depositValue)) {
                        Driver.generateInvalidDollarAmountMessage();
                        depositValue = scan.next();
                    }

                    atm.deposit(Double.parseDouble(depositValue));
                    atm.updateBalanceInBankRepository();
                    System.out.println();
                    System.out.println("You've successfully deposited into your account");
                    System.out.println(atm.getCustomerAccountInfo());
                    break;
                // Allows for the user to make withdrawals from their account
                case '3':
                    System.out.println();
                    System.out.print("Enter the amount you'd wish to withdraw in decimal format: $");
                    String withdraw = scan.next();

                    while(!Driver.isDouble(withdraw)) {
                        Driver.generateInvalidDollarAmountMessage();
                        withdraw = scan.next();
                    }

                    double balance = currentCustomer.getBalance();
                    // Checks to see if the user has a sufficient balance to accommodate their requested withdrawal
                    while (!atm.isAbleToWithdrawAmount(balance, Double.parseDouble(withdraw))) {
                        System.out.println();
                        System.out.println("Withdrawal cannot be made - You currently have $"
                                            + df2.format(currentCustomer.getBalance()) + " in your account");
                        System.out.println();
                        System.out.println("Please re-enter a valid amount" +
                                            " or enter \'prev\' to return to user menu or enter \'exit\' to quit the program");
                        System.out.print("Enter option: ");
                        withdraw = scan.next();

                        // Allows user making invalid withdrawal to go to previous screen or exit program
                        if(Driver.isPrevOrExit(withdraw)) {
                            if(withdraw.equals("prev")) {
                                continue prev;
                            }
                            if(withdraw.equals("exit")) {
                                break prev;
                            }
                        }
                        while(!Driver.isDouble(withdraw)) {
                            Driver.generateInvalidDollarAmountMessage();
                            withdraw = scan.next();
                        }
                    }
                    // Performs the withdrawal and updates the bank's repository
                    atm.isAbleToWithdrawAmount(currentCustomer.getBalance(), Double.parseDouble(withdraw));
                    atm.withdraw(Double.parseDouble(withdraw));
                    atm.updateBalanceInBankRepository();
                    System.out.println();
                    if(!withdraw.equals("0")) {
                        System.out.println("You've successfully withdrawn $" + withdraw
                                            + " from your account");
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }

            System.out.println("To return to user menu enter \'prev\' or if you'd like to exit enter \'exit\'");
            System.out.print("Input a command and press enter: ");
            String exitOrPrev = scan.next();

            // Checks to see if the user wants to exit the program or return to the user menu
            while(!Driver.isPrevOrExit(exitOrPrev)) {
                System.out.println();
                System.out.println("To return to user menu enter \'prev\' or if you'd like to exit enter \'exit\'");
                System.out.print("Input a command and press enter: ");
                exitOrPrev = scan.next();
                System.out.println();
            }

            if(exitOrPrev.equals("exit")) {
                scan.close();
                System.exit(0);
            }
        }
    }
}
