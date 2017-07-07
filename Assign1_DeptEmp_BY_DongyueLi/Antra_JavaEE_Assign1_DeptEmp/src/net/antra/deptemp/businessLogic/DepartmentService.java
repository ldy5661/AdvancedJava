package net.antra.deptemp.businessLogic;

import java.util.ArrayList;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;

public class DepartmentService {
	public ArrayList<Department> addNewDepartment(String name, String email, String[] empIDArray, ArrayList<Employee> existingEmpList, ArrayList<Department> existingDempList) {
		ArrayList<Department> deptList;
		if(existingDempList != null) {
			deptList = existingDempList;
		} else {
			deptList = new ArrayList<>();
		}
		if(name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
			Department newDemp = new Department();
			newDemp.setName(name);
			newDemp.setEmail(email);
			ArrayList<Employee> empListToBeAdded = new ArrayList<>();
			ArrayList<Employee> empList;
			if (existingEmpList != null) {
				empList = existingEmpList;
				if(empIDArray != null && empIDArray.length != 0) {
					for (String empID : empIDArray) {
						Integer id = Integer.parseInt(empID);
						for (Employee emp : empList) {
							if (emp.getId().equals(id)) {
								empListToBeAdded.add(emp);
							}
						}
					}
				}
			}
			// get a collection of employees that need to be added to a same department
			newDemp.setEmpList(empListToBeAdded);
			// get a collection of new departments
			deptList.add(newDemp);
		}
		return deptList;
	}
}
