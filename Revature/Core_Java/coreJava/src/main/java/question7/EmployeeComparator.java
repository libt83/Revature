package question7;

import java.util.Comparator;

/**
 * @author Brandon Semba
 * 
 * Sort two employees based on their name, department, 
 * and age using the Comparator interface.
 */
@SuppressWarnings("rawtypes")
public class EmployeeComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		if(o1 instanceof Employee && o1 instanceof Employee) {
			Employee emp1 = (Employee)o1;
			Employee emp2 = (Employee)o2;

			// Logic for first comparing Employees by names then depts
			// then age
			if(emp1.name.compareTo(emp2.name) < 0) {
				return -1;
			} else if(emp1.name.compareTo(emp2.name) > 0) {
				return 1;
			}else if(emp1.department.compareTo(emp2.department) < 0) {
				return -1;
			}else if(emp1.department.compareTo(emp2.department) > 0) {
				return 1;
			}else if(emp1.age < emp2.age) {
				return -1;
			}else if(emp1.age > emp2.age) {
				return 1;
			}else {
				return 0;
			}
		}
		return 0;
	}
	
	// inner-class for employee objects
	public class Employee {
		String name;
		String department;
		int age;
		
		public Employee(String name, String dept, int age) {
			this.name = name.toLowerCase();
			this.department = dept.toLowerCase();
			this.age = age;
		}
	}
}
