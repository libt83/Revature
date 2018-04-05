package question8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brandon Semba
 * 
 *Write a program that stores the following strings in 
 *an ArrayList and saves all the palindromes in another 
 *ArrayList."karan", "madam", "tom", "civic", "radar", "jimmy",
 * "kayak", "john",  "refer", "billy", "did"
 *
 */
public class PalindromeList {
	
	/**
	 * Stores string tokens into one array and stores the tokens that are palindromes
	 * into another array.
	 * 
	 * @param string - the string containing tokens
	 * @param strArr - the array for the string tokens
	 * @param palinArr - the array for the palindrome tokens
	 * @return the list containing the palindromes
	 */
	public ArrayList<String> storeStringsAndPalindromes(String string,
		List<String> strArr, List<String> palinArr) {
		// tokenize the string
		String[] tokenArr = string.split(", ", 0);
		
		for(String str: tokenArr) {
			strArr.add(str);
			//reversing string for comparison to original
			StringBuilder sb = new StringBuilder(str).reverse();
			if(str.equals(sb.toString())) {
				palinArr.add(str);
			}	
		}
		return (ArrayList<String>) palinArr;
	}
}
