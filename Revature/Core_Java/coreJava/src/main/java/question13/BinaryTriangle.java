package question13;

/**
 * @author Brandon Semba
 *
 *	Displays a binary right triangle without the use of a group of 
 *	print statements
 */
public class BinaryTriangle {

	/**
	 * Creates and displays a binary right triangle
	 * 
	 * @return the string containing the binary right triangle
	 */
	public String generateBinaryTriangle() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < i + 1; j++) {
				if((i + j) % 2 == 0) {
					sb.append("0");
				}else {
					sb.append("1");
				}
				// Ensures space isn't appended to end of level
				if(j + 1 < i + 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
