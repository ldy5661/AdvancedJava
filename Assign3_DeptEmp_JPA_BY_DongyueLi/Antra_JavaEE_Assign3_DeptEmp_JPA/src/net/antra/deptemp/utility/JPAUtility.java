package net.antra.deptemp.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("dept_emp_proj_pu");
	
	//singleton
	private JPAUtility(){
	}
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}
}
