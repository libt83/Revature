package question6test;

import static org.junit.Assert.*;

import org.junit.Test;

import question6.EvenWithOutMod;

public class EvenWithOutModTest {

	@Test
	public void testIsEven() {
		EvenWithOutMod tester = new EvenWithOutMod();
		
		assertFalse(tester.isEven(0));
		assertTrue(tester.isEven(8));
		assertFalse(tester.isEven(11));	
	}
}
