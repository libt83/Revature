package question12;

/**
 * @author Brandon Semba
 * 
 * Write a program to store numbers from 1 to 100 in<br>
 * an array. Print out all the even numbers from the array.<br>
 * Use the enhanced FOR loop for printing out the numbers.<br>
 *
 */
public class EvenNumsInArray {

	/**
	 * Prints the even numbers stored in an array
	 * 
	 * @param arr - the given array
	 */
	public void printEvenInArray(int[] arr) {
		for(int num: arr) {
			if(num % 2 == 0)
				System.out.println(num);
		}
	}
	
	/**
	 * Stores integers into an array from 1 to 100
	 * 
	 * @return an array of numbers from 1 to 100
	 */
	public int[] storeNumsInArray() {
		int[] arr = new int[100];
		
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		return arr;
	}
}
