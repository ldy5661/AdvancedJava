package net.antra.deptemp.businessLogic;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import net.antra.deptemp.entity.Department;
import net.antra.deptemp.utility.JPAUtility;

public class DepartmentService {
	public List<Department> addNewDepartment(String name, String email) {
		if(name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
			EntityManager em = JPAUtility.getEntityManager();
			em.getTransaction().begin();
			Department dept = new Department();
			dept.setName(name);
			dept.setEmail(email);
			em.persist(dept);
			em.getTransaction().commit();
		}
		return getDeptList();
	}

	public List<Department> getDeptList() {
		EntityManager em = JPAUtility.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select distinct d from Department d");
		List<Department> resList = query.getResultList();
		em.getTransaction().commit();
		return resList;
	}
}
