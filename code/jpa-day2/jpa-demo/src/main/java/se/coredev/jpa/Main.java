package se.coredev.jpa;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.model.Address;
import se.coredev.jpa.model.Computer;
import se.coredev.jpa.model.Role;
import se.coredev.jpa.model.User;

public final class Main {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

		EntityManager manager = factory.createEntityManager();
				
		Computer computer = new Computer("MacBook pro", UUID.randomUUID().toString());
		Role role = new Role("admin");
		User user = new User("master", new Address("street", "postal", "zip"), computer, role);
		
		manager.getTransaction().begin();
		manager.persist(user);
		manager.persist(computer);
		manager.persist(role);
		manager.getTransaction().commit();
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
//			manager.persist(new User("username" + i, null, null));
		}

		manager.getTransaction().commit();
	}

}
