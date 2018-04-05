package question18;

/**
 * @author Brandon Semba
 *
 * Question 18: The concrete class that will be providing implementation<br>
 * for the 3 inherited abstract methods.
 */
public class ConcreteExample extends AbstractExample{

	@Override
	public boolean containsUppercaseChar(String theString) {
		for(char ch: theString.toCharArray()) {
			//checking the ascii uppercase decimal range
			if(ch >= 65 && ch <= 90)
				return true;
		}
		return false;
	}

	@Override
	public String convertLowercaseToUppercase(String theString) {
		StringBuilder sb = new StringBuilder();
		for(char ch: theString.toCharArray()) {
			//checking in the ascii lowercase decimal range
			if(ch >= 97 && ch <= 122) {
				sb.append(Character.toUpperCase(ch));
			}else {
				sb.append(ch);
			}
				
		}
		return sb.toString();
	}

	@Override
	public int convertStringToIntAndAdd10(String theString) {
		return Integer.parseInt(theString) + 10;
		
	}
}
