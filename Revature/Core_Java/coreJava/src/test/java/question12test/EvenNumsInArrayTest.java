package question12test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question12.EvenNumsInArray;

public class EvenNumsInArrayTest {

	private EvenNumsInArray tester;
	
	@Before
	public void setup() {
		tester = new EvenNumsInArray();
	}
	
	@Test
	public void testPrintEvenInArray() {
		int[] testArr = tester.storeNumsInArray();
		// Wasn't quite sure how to go about testing this one
		// so I just put its logic in
		int evenCounter = 2;
		for(int i : testArr) {
			if(i % 2 == 0) {
				assertEquals(evenCounter, i);
				evenCounter += 2;
			}
		}
	}

	@Test
	public void testStoreNumsInArray() {
		int[] testArr = tester.storeNumsInArray();
		int counter = 1;
		
		for(int i : testArr) {
			assertEquals(counter++, i);
		}
	}
}
