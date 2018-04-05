package question5;

/**
 * @author Brandon Semba
 * 
 * Provides a custom implementation for a substring method,
 * without utilizing any substring methods in its creation.
 */
public class SubString {

	public String subString(String str, int index) {
		if(index > str.length())
			throw new IndexOutOfBoundsException();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < index; i++) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
