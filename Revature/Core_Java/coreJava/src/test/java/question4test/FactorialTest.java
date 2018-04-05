package question4test;

import static org.junit.Assert.*;

import org.junit.Test;

import question4.Factorial;

public class FactorialTest {

	@Test
	public void testFactorial() {
		Factorial tester = new Factorial();
		
		assertEquals(1, tester.factorial(1));
		assertEquals(120, tester.factorial(5));
		assertEquals(3628800, tester.factorial(10));
	}

}
