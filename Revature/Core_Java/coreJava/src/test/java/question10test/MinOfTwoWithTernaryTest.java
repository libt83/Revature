package question10test;

import static org.junit.Assert.*;

import org.junit.Test;

import question10.MinOfTwoWithTernary;

public class MinOfTwoWithTernaryTest {

	@Test
	public void testMinOfTwoNums() {
		MinOfTwoWithTernary tester = new MinOfTwoWithTernary();
		int num1 = 8;
		int num2 = 3;
		
		assertEquals(3, tester.minOfTwoNums(3, 8));
		assertEquals(3, tester.minOfTwoNums(8, 3));
		assertEquals(-1, tester.minOfTwoNums(-1, 3));
	}


}
