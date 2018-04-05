package question3;

/**
 * @author Brandon Semba
 * 
 * Reversing a String without the use of a temp variable and without
 * the use of the reverse() method.
 */
public class StringReverse {

	public String reverseString(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
