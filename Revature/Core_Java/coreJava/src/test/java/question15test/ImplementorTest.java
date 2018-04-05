package question15test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question15.Implementor;

public class ImplementorTest {
	private Implementor tester;
	
	@Before
	public void setup() {
		tester = new Implementor();
	}
	
	@Test
	public void testAddition() {
		assertEquals(5, tester.addition(2, 3));
		assertEquals(5, tester.addition(3, 2));
	}

	@Test
	public void testSubtraction() {
		assertEquals(-1, tester.subtraction(2, 3));
		assertEquals(-1, tester.subtraction(-3, -2));
		assertEquals(37, tester.subtraction(40, 3));
	}

	@Test
	public void testMultiplication() {
		assertEquals(6, tester.multiplication(2, 3));
		assertEquals(6, tester.multiplication(-3, -2));
	}

	@Test
	public void testDivision() {
		assertEquals(5, tester.division(10, 2));
		assertEquals(0, tester.division(1, 3));
		assertEquals(0, tester.division(0, 3));
	}
	
	@Test(expected = ArithmeticException.class) 
	public void divideByZero() { 
	     tester.division(10, 0);
	}

}
