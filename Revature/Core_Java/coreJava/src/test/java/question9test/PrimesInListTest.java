package question9test;

import static org.junit.Assert.*;

import org.junit.Test;

import question9.PrimesInList;

public class PrimesInListTest {

	@Test
	public void testFindPrimesTo100() {
		PrimesInList tester = new PrimesInList();
		String expected = "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97";
		
		assertEquals(expected, tester.findPrimesTo100());
	}

}
