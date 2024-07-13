package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.classes.Admin;
import entity.classes.User;

public class CreateUsers {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vote_management_system");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		User user1 = new User("Deepak", "deepak12@gmail.com", "deepak1234","Rajsthan", 19, "male", "Banshi", "Vimal", "20-03-2005");
	
		et.begin();
			em.persist(user1);
		et.commit();
	}

}
