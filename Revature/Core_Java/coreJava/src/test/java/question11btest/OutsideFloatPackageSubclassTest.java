package question11btest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question11b.OutsideFloatPackageSubclass;

public class OutsideFloatPackageSubclassTest {

	private OutsideFloatPackageSubclass tester;
	
	@Before
	public void setup() {
		tester = new OutsideFloatPackageSubclass();
	}
	
	@Test
	public void testGetProtecedFloat1() {
		assertEquals((Float)10.0f, (Float)tester.getProtecedFloat1());
	}

	@Test
	public void testGetProtecedFloat2() {
		assertEquals((Float)12.0f, (Float)tester.getProtecedFloat2());
	}

}
