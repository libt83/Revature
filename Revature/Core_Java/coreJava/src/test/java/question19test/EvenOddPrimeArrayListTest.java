package question19test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import question19.EvenOddPrimeArrayList;

public class EvenOddPrimeArrayListTest {

	private EvenOddPrimeArrayList tester;
	
	private List<Integer> testList;

	@Before
	public void setup( ) {
		tester = new EvenOddPrimeArrayList();
		testList = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++) {
			testList.add(i);
		}
	}
	
	@Test
	public void testDisplaySumOfEvenNumsInList() {
		assertEquals(30, tester.displaySumOfEvenNumsInList(testList));
	}

	@Test
	public void testDisplaySumOfOddNumsInList() {
		assertEquals(25, tester.displaySumOfOddNumsInList(testList));
	}

	@Test
	public void testRemovePrimesFromList() {
		testList = tester.removePrimesFromList(testList);
		
		assertEquals(6, testList.size());
		assertEquals(1, (int)testList.get(0));
		assertEquals(4, (int)testList.get(1));
		assertEquals(6, (int)testList.get(2));
		assertEquals(8, (int)testList.get(3));
		assertEquals(9, (int)testList.get(4));
		assertEquals(10, (int)testList.get(5));
	}
}
