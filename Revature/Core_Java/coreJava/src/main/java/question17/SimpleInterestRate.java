package question17;

import java.util.Scanner;

/**
 * @author Brandon Semba
 * 
 * Write a program that calculates the simple interest on the principal, rate of interest
 * and number of years provided by the user. Enter principal, rate and time through the 
 * console using the Scanner class. Interest = Principal* Rate* Time
 *
 */
public class SimpleInterestRate {

	public void displaySimpleInterestRate() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Simple Interest Calculator!");
		System.out.print("Please enter your principal: ");
		int principal = sc.nextInt();
		System.out.print("Please enter your rate of interest (in decimal): ");
		double rate = sc.nextDouble();
		System.out.print("Please enter the length of the loan: ");
		int lengthOfLoan = sc.nextInt();
		System.out.println("Your simple interest for the information provided is "
							+ (principal * rate * lengthOfLoan));
		sc.close();	
	}
}
