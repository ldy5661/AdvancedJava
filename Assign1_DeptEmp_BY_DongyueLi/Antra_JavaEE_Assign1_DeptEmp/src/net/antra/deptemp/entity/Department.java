package net.antra.deptemp.entity;

import java.util.List;

public class Department {
	private Integer id;
	private String name;
	private String email;
	private static Integer count = 1;
	private List<Employee> empList;
	
	public Department() {
		this.id = count;
		count++;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
}
