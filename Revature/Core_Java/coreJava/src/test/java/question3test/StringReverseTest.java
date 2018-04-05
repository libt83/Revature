package question3test;

import static org.junit.Assert.*;

import org.junit.Test;

import question3.StringReverse;

public class StringReverseTest {

	@Test
	public void testReverseString() {
		StringReverse tester = new StringReverse();
		String testString1 = "toot";
		String testString2 = "a";
		String testString3 = "Brandon Semba";
		
		assertEquals("toot", tester.reverseString(testString1));
		assertEquals("a", tester.reverseString(testString2));
		assertEquals("abmeS nodnarB", tester.reverseString(testString3));
	}

}
