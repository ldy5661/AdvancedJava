package net.antra.deptemp.entity;

public class Employee {
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private static Integer count = 1;
	
	public Employee() {
		this.id = count;
		count++;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
