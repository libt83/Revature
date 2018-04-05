package question13test;

import static org.junit.Assert.*;

import org.junit.Test;

import question13.BinaryTriangle;

public class BinaryTriangleTest {

	@Test
	public void testGenerateBinaryTriangle() {
		BinaryTriangle tester = new BinaryTriangle();
		String expected = "0\n" + "1 0\n" + "0 1 0\n" + "1 0 1 0\n";
		assertEquals(expected, tester.generateBinaryTriangle());
	}

}
