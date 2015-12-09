package se.coredev.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.model.User;

public final class Main {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

		EntityManager manager = factory.createEntityManager();
				
		manager.close();
		
	}
	
	private static List<User> getAll(EntityManager manager){
		return manager.createQuery("select u from User u", User.class).getResultList();
	}
	
	private static User getEmployeeById(EntityManager manager, Long id){
		return manager.find(User.class, id);
	}

	private static void addUsers(EntityManager manager, int numberOfUsers) {

		manager.getTransaction().begin();

		for (int i = 0; i < numberOfUsers; i++) {
			User user = new User(null);
			manager.persist(user);
		}

		manager.getTransaction().commit();
	}

}
