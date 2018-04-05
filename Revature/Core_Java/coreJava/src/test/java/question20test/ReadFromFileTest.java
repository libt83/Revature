package question20test;

import static org.junit.Assert.*;

import org.junit.Test;

import question20.ReadFromFile;

public class ReadFromFileTest {

	@Test
	public void testReadAndParse() {
		ReadFromFile tester = new ReadFromFile();
		String expected = "Name: Mickey Mouse\n"
						+ "Age: 35 years\n"
						+ "State: Arizona State\n"
						+ "\n"
						+ "Name: Hulk Hogan\n"
						+ "Age: 50 years\n"
						+ "State: Virginia State\n"
						+ "\n"
						+ "Name: Roger Rabbit\n"
						+ "Age: 22 years\n"
						+ "State: California State\n"
						+ "\n"
						+ "Name: Wonder Woman\n"
						+ "Age: 18 years\n"
						+ "State: Montana State\n"
						+ "\n";
		assertEquals(expected, tester.readAndParse());					
	}
}
