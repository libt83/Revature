package question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Brandon Semba
 *
 *  * Demonstrates the use of a switch case with each case providing a different procedure.
 */
public class SwitchCaseDemo {
	
	/**
	 * Demonstrates the use of the switch statement
	 * 
	 * @param option - corresponds to one of the 3 cases
	 */
	public void switchDemo(int option) {
		switch(option) {
			case 1:
				Scanner sc = new Scanner(System.in);
				System.out.print("Please enter a number: ");
				double num = sc.nextDouble();
				System.out.println("The square root of " + num + " = " + Math.sqrt(num));
				num = (int) Math.sqrt(num);
				break;
			case 2:
				Calendar cal = new GregorianCalendar();
				Date date = cal.getTime();
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				System.out.println(dateFormat.format(date));
				break;
			case 3:
				String str = "I am learning Core Java";
				String[] arr = str.split(" ", 0);
				for(String token: arr) {
					System.out.println(token);
				}
				break;		
		}
	}
}
