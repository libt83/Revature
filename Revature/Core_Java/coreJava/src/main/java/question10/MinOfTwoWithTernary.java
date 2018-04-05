package question10;

/** 
 * @author Brandon Semba
 * 
 * Find the minimum of two numbers using ternary operators.
 */
public class MinOfTwoWithTernary {

	/**
	 * Determines which number is less than the other.
	 * 
	 * @param num1 - the first number
	 * @param num2 - the second number
	 * @return the lesser of the two numbers
	 */
	public int minOfTwoNums(int num1, int num2) {
		return num1 < num2 ? num1: num2;
	}
}
