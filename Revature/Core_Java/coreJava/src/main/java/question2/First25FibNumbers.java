package question2;

/**
 * @author Brandon Semba
 * 
 * Uses an iterative approach for displaying the 
 * first 25 Fibonacci numbers.
 * Uses 0 as the start of the sequence
 */
public class First25FibNumbers {
	
	public String first25FibNumbers() {
		int prev = 0;
		int next = 1;
		int result = 0;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(prev + ", " + next);
		
		for(int i = 1; i <= 23; i++) {
			result = prev + next;
			sb.append(", " + result);
			prev = next;
			next = result;

		}
		return sb.toString();	
	}
}
