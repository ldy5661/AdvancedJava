package net.antra.deptemp.businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;
import net.antra.deptemp.utility.JDBCUtility;

public class DepartmentService {
	public ArrayList<Department> addNewDepartment(String name, String email) {
		try(Connection conn = JDBCUtility.getConnection();
				PreparedStatement stmt = conn.prepareStatement("insert into department (dept_name, dept_email) values (?, ?)");
			){
			if(name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return getDeptList();
	}

	public ArrayList<Department> getDeptList() {
		ArrayList<Department> deptList = new ArrayList<Department>();
		
		try(Connection conn = JDBCUtility.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from department");
				PreparedStatement stmt2 = 
						conn.prepareStatement("select e.emp_id, e.first_name, e.last_name, e.age "
								+ "from employee e inner join department d "
								+ "on e.dept_id = d.dept_id where d.dept_id = ?");
			){
			while(rs.next()) {
				Integer deptId = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				String deptEmail = rs.getString("dept_email");
				//load emplist for the department
				List<Employee> empList = new ArrayList<>();
				stmt2.setInt(1, deptId);
				ResultSet rsEmp = stmt2.executeQuery();
				while(rsEmp.next()) {
					Integer empId = rsEmp.getInt("emp_id");
					String firstName = rsEmp.getString("first_name");
					String lastName = rsEmp.getString("last_name");
					Integer age = rsEmp.getInt("age");
					empList.add(new Employee(empId, firstName, lastName, age, null));
				}
				deptList.add(new Department(deptId, deptName, deptEmail, empList));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deptList;
	}
}
