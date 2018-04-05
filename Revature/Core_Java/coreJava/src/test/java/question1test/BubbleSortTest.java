package question1test;

import static org.junit.Assert.*;

import org.junit.Test;

import question1.BubbleSort;

public class BubbleSortTest {

	@Test
	public void testBubbleSort() {
		BubbleSort tester = new BubbleSort();
		int[] testArr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		
		testArr = tester.bubbleSort(testArr);
		
		for(int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], testArr[i]);
		}
	}

}
