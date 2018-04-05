package question14test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;


public class SwitchCaseDemoTest {

	// Just provided the logic used for each case as I wasn't sure how to test it
	@Test
	public void testSwitchDemo1() {
		double scannedInt = 25;
		Double expected = (double) 5;
		assertEquals(expected, (Double)Math.sqrt(scannedInt));
	}
	
	@Test
	public void testSwitchDemo2() {
		Calendar cal = new GregorianCalendar();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		assertEquals("04/03/2018", dateFormat.format(date));
	}
	
	@Test
	public void testSwitchDemo3() {
		String str = "I am learning Core Java";
		String[] arr = str.split(" ", 0);
		
		assertEquals("I", arr[0]);
		assertEquals("am", arr[1]);
		assertEquals("learning", arr[2]);
		assertEquals("Core", arr[3]);
		assertEquals("Java", arr[4]);
	}

}
