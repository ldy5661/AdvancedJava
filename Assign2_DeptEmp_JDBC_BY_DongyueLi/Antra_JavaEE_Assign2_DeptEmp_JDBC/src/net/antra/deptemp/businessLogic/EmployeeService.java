package net.antra.deptemp.businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;
import net.antra.deptemp.utility.JDBCUtility;

public class EmployeeService {
	public ArrayList<Employee> addNewEmployee(String firstName, String lastName, String age, String deptId) throws SQLException {
		try(Connection conn = JDBCUtility.getConnection();
				PreparedStatement stmt = conn.prepareStatement("insert into employee (first_name, last_name, age, dept_id) values (?, ?, ?, ?)");
			){
			if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty() && age != null && !age.trim().isEmpty() && deptId != null && !deptId.isEmpty()) {
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				stmt.setInt(3, Integer.parseInt(age));
				stmt.setInt(4, Integer.parseInt(deptId));
				stmt.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return getEmpList();
	}

	public ArrayList<Employee> getEmpList() throws SQLException {
		ArrayList<Employee> empList = new ArrayList<>();
		try(Connection conn = JDBCUtility.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from employee");
				PreparedStatement stmt2 = conn.prepareStatement("select dept_name, dept_email from department where dept_id = ?");
			) {
			while(rs.next()) {
				Integer empId = rs.getInt("emp_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Integer age = rs.getInt("age");
				Integer deptId = rs.getInt("dept_id");
				//load department for the employee
				stmt2.setInt(1, deptId);
				ResultSet rsDept = stmt2.executeQuery();
				Department dept = new Department();
				dept.setId(deptId);
				while(rsDept.next()) {
					dept.setName(rsDept.getString("dept_name"));
					dept.setEmail(rsDept.getString("dept_email"));
				}
				empList.add(new Employee(empId, firstName, lastName, age, dept));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
}
