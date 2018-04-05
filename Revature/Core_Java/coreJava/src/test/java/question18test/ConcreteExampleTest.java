package question18test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question18.ConcreteExample;



public class ConcreteExampleTest{
	
	private ConcreteExample tester;
	
	@Before
	public void setup() {
		 tester = new ConcreteExample();
	}
	
	@Test
	public void testContainsUppercaseChar() {
		String testString1 = "cat";
		String testString2 = "Uncle";
		String testString3 = "appleE";
		String testString4 = "apPle";
		String testString5 = "";
		
		assertFalse(tester.containsUppercaseChar(testString1));
		assertTrue(tester.containsUppercaseChar(testString2));
		assertTrue(tester.containsUppercaseChar(testString3));
		assertTrue(tester.containsUppercaseChar(testString4));
		assertFalse(tester.containsUppercaseChar(testString5));	
	}

	@Test
	public void testConvertLowercaseToUppercase() {
		String testString1 = "cat";
		String testString2 = "CAT";
		String testString3 = "caT";
		String testString4 = "Cat";
		
		assertEquals("CAT", tester.convertLowercaseToUppercase(testString1));
		assertEquals("CAT", tester.convertLowercaseToUppercase(testString2));
		assertEquals("CAT", tester.convertLowercaseToUppercase(testString3));
		assertEquals("CAT", tester.convertLowercaseToUppercase(testString4));
	}

	@Test
	public void testConvertStringToIntAndAdd10() {
		String testString1 = "0";
		String testString2 = "90";
		String testString3 = "199999999";
		
		assertEquals(10, tester.convertStringToIntAndAdd10("0"));
		assertEquals(100, tester.convertStringToIntAndAdd10("90"));
		assertEquals(200000009, tester.convertStringToIntAndAdd10("199999999"));
	}

}
