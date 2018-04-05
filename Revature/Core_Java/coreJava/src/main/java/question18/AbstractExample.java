package question18;

/**
 * @author Brandon Semba
 * 
 * Question 18: The abstract class that includes 3 abstract methods.
 */
public abstract class AbstractExample {
	/**
	 * Checks to see if the string contains at least 1 upper-case character
	 * 
	 * @param theString - the string to check
	 * @return true if an uppercase character is present; false otherwise
	 */
	public abstract boolean containsUppercaseChar(String theString);
	
	/**
	 * Converts any lower-case characters in the string into upper-case characters
	 * 
	 * @param theString the string being converted
	 * @return a string contained all upper-case characters
	 */
	public abstract String convertLowercaseToUppercase(String theString);
	
	/**
	 * Converts the string literal into an integer and adds 10 to its value.<br>
	 * The result is output to the console.
	 * 
	 * @param theString - the string being converted
	 */
	public abstract int convertStringToIntAndAdd10(String theString);
}
