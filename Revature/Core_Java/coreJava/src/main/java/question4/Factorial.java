package question4;

/**
 * @author Brandon Semba
 * 
 * Recursively computes the Nth factorial.
 */
public class Factorial {
	
	public int factorial(int n) {
		if(n < 2)
			return 1;
		else
			return n * factorial(n - 1);
	}
}
