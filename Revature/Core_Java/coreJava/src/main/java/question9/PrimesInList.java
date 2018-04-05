package question9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brandon Semba
 * 
 * Create an ArrayList which stores numbers from
 * 1 to 100 and prints out all the prime numbers to the console.<
 *
 */
public class PrimesInList {

	/**
	 * Creates a an array list with 1-100 stored in it for also printing the prime numbers in that range
	 * 
	 * @return a string containing all the prime numbers in the range
	 */
	public String findPrimesTo100() {
		List<Integer> intList = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		intList.add(1);
		intList.add(2);
		
		sb.append(2);
		System.out.println(2);
		
		// fill list from 3-100 - because 1 is not prime
		// and 2 is the only even prime number
		for(int i = 3; i <= 100; i++) {
			intList.add(i);
			if(i % 2 == 0) {
				continue;
			}else {
				// check if odd numbers are divisible by their odd factors
				int temp = i - 2;
				while(temp > 1) {
					if(i % temp == 0) {
						break;
					}else {
						temp -= 2;
					}
				}
				// check to determine if the odd numbers factor reached 1
				// making it a prime number
				if(temp == 1) {
					sb.append(" " + i);
					System.out.print(i + " ");
				}
			}
		}
		return sb.toString();
	}
}
