package question19;

import java.util.List;
/**
 * @author Brandon Semba
 * 
 * Provides methods that can sum up the odd elements, sum up the even elements, and
 * remove the prime elements from a list containing value 1...10
 */
public class EvenOddPrimeArrayList {
	
	/**
	 * Sums the even numbers in the list and displays<br>
	 * the sum in the console.
	 * 
	 * @param the list of integers from 1...10
	 * @return returns the sum of the even numbers in the list
	 */
	public int displaySumOfEvenNumsInList(List<Integer> list) {
		int sum = 0;
		for(int num : list) {
			if(num % 2 == 0)
				sum += num;
		}
		System.out.println(sum);
		return sum;
	}
	
	/**
	 * Sums the odd numbers in the list and displays<br>
	 * the sum in the console.
	 * 
	 * @param the list of integers from 1...10
	 * @returns the sum of the odd numbers in the list
	 */
	public int displaySumOfOddNumsInList(List<Integer> list) {
		int sum = 0;
		for(int num : list) {
			if(num % 2 == 1)
				sum += num;
		}
		System.out.println(sum);
		return sum;
	}
	
	/**
	 * Removes prime numbers from a list containing integers in the range of 1...10
	 * 
	 * @param list the list of integers 1...10
	 * @return a list containing prime numbers in range 1...10
	 */
	public List<Integer> removePrimesFromList(List<Integer> list) {
		list.remove(1);
		list.remove(1);
		list.remove(2);
		list.remove(3);
		
		for(int i : list) {
			System.out.println(i);
		}
		
		return list;
	}
}
