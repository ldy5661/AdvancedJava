package net.antra.deptemp.businessLogic;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.antra.deptemp.entity.Department;
import net.antra.deptemp.entity.Employee;
import net.antra.deptemp.utility.JPAUtility;

public class EmployeeService {
	// add JPA need to change here. Do not have to create JDBCUtility to connect DB
	public List<Employee> addNewEmployee(String firstName, String lastName, String age, String deptId) throws SQLException {
		if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty() && age != null && !age.trim().isEmpty() && deptId != null && !deptId.isEmpty()) {
			EntityManager em = JPAUtility.getEntityManager();
			em.getTransaction().begin();
			/**Use the getReference call of the entityManager to load department object using the deptId 
				and then set that onto the employee. 
				In most cases this call would return a proxy with just the id embedded, 
				the department attributes will not be loaded unless some other method of the department is invoked. */
			Department dept = em.getReference(Department.class, Integer.parseInt(deptId));	
			Employee emp = new Employee();
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setAge(Integer.parseInt(age));
			emp.setDepartment(dept);
			em.persist(emp);
			em.getTransaction().commit();
		}
		return getEmpList();
	}	

	public List<Employee> getEmpList() throws SQLException {
		EntityManager em = JPAUtility.getEntityManager();
		em.getTransaction().begin();
		// Must be Employee not employee
		// org.hibernate.hql.internal.ast.QuerySyntaxException: employee is not mapped [select e from employee e]
		Query query = em.createQuery("select e from Employee e");
		List<Employee> resList = query.getResultList();
		em.getTransaction().commit();
		return resList;
	}
}
