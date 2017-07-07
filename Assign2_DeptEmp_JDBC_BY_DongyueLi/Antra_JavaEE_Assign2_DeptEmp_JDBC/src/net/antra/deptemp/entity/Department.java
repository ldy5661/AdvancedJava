package net.antra.deptemp.entity;

import java.util.List;

public class Department {
	private Integer id;
	private String name;
	private String email;
	private List<Employee> empList;
	
	public Department(){
	}
	
	public Department(Integer id, String name, String email, List<Employee> empList) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.empList = empList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
