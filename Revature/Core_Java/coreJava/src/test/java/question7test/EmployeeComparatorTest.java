package question7test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question7.EmployeeComparator;

public class EmployeeComparatorTest {

	private EmployeeComparator tester;
	
	private EmployeeComparator.Employee emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8;

	@Before
	public void setup() {
		tester = new EmployeeComparator();
		
		emp1 = tester.new Employee("Steve", "math", 34);
		emp2 = tester.new Employee("Steven", "math", 34);
		emp3 = tester.new Employee("Steve", "math", 34);
		emp4 = tester.new Employee("Steve", "mathe", 34);
		emp5 = tester.new Employee("Steve", "math", 34);
		emp6 = tester.new Employee("Steve", "math", 35);
		emp7 = tester.new Employee("Steve", "math", 34);
		emp8 = tester.new Employee("Steve", "math", 34);
	}
	
	@Test
	public void testCompare() {
		assertEquals(-1, tester.compare(emp1, emp2));
		assertEquals(1, tester.compare(emp2, emp1));
		assertEquals(-1, tester.compare(emp3, emp4));
		assertEquals(1, tester.compare(emp4, emp3));
		assertEquals(-1, tester.compare(emp5, emp6));
		assertEquals(1, tester.compare(emp6, emp5));
		assertEquals(0, tester.compare(emp7, emp8));
	}

}
