package question5test;

import static org.junit.Assert.*;

import org.junit.Test;

import question5.SubString;

public class SubStringTest {

	@Test
	public void testSubString() {
		SubString tester = new SubString();
		String testString = "Brandon Semba";
		
		assertEquals("B", tester.subString(testString, 1));
		assertEquals("Brandon", tester.subString(testString, 7));
		assertEquals("", tester.subString(testString, 0));
		assertEquals("Brandon Semba", tester.subString(testString, testString.length()));
	}
}
