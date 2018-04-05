package question6;

/**
 * @author Brandon Semba
 * 
 * Determines if a number is even without the use of the 
 * modulus operator
 */
public class EvenWithOutMod {

	public boolean isEven(int n) {
		if(n == 0)
			return false;
		else
			return (n & 1) == 0;
	}
}
