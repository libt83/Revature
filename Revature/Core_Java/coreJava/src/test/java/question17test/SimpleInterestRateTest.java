package question17test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleInterestRateTest {

	@Test
	public void testDisplaySimpleInterestRate() {
		// Just put the methods logic in here to test
		// wasn't sure how else to test the user input with scanner
		int scanForPrincipal = 12000;
		double scanForRate = .15;
		int scanForLengthOfLoan = 12;
		int interest = (int) (scanForPrincipal * .15 * 12);	
		
		assertEquals(21600, interest);
	}

}
