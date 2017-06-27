package net.antra.deptemp.businessLogic;

import java.util.ArrayList;

import net.antra.deptemp.entity.Employee;

public class EmployeeService {
	public ArrayList<Employee> addNewEmployee(String firstName, String lastName, String age, ArrayList<Employee> existingList) {
		ArrayList<Employee> empList;
		if (existingList != null) {
			empList = existingList;
		} else {
			empList = new ArrayList<>();
		}
		if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty() && age != null && !age.trim().isEmpty()) {
			Employee newEmp = new Employee();
			newEmp.setFirstName(firstName);
			newEmp.setLastName(lastName);
			newEmp.setAge(Integer.parseInt(age));
			empList.add(newEmp);	
		}
		return empList;
	}
}
