package question8test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import question8.PalindromeList;

public class PalindromeListTest {

	@Test
	public void testStoreStringsAndPalindromes() {
		PalindromeList tester = new PalindromeList();
		String test = "karan, madam, tom, civic, radar, jimmy, kayak, john, refer, billy, did";
		ArrayList<String> testArr = new ArrayList<String>();
		ArrayList<String> testPalinList = new ArrayList<String>();
		testPalinList = tester.storeStringsAndPalindromes(test, testArr, testPalinList);
		
		assertTrue(testPalinList.contains("madam"));
		assertTrue(testPalinList.contains("civic"));
		assertTrue(testPalinList.contains("radar"));
		assertTrue(testPalinList.contains("kayak"));
		assertTrue(testPalinList.contains("refer"));
		assertTrue(testPalinList.contains("did"));
		
		assertEquals(6, testPalinList.size());
	}

}
