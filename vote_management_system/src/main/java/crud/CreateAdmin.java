package crud;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.classes.Admin;
import entity.classes.User;


public class CreateAdmin {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vote_management_system");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		User user = em.find(User.class, 1);
		
		Admin admin = new Admin("Admin", "admin1234",user);
		
		et.begin();
			em.persist(admin);
		et.commit();
	}

}
