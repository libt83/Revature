package question2test;

import static org.junit.Assert.*;

import org.junit.Test;

import question2.First25FibNumbers;

public class First25FibNumbersTest {

	@Test
	public void testFirst25FibNumbers() {
		First25FibNumbers tester = new First25FibNumbers();
		String fibTest = "0, 1, 1, 2, 3, 5, 8, 13,"
				+ " 21, 34, 55, 89, 144, 233, 377, "
				+ "610, 987, 1597, 2584, 4181, 6765, "
				+ "10946, 17711, 28657, 46368";
		assertEquals(fibTest, tester.first25FibNumbers());
	}

}
