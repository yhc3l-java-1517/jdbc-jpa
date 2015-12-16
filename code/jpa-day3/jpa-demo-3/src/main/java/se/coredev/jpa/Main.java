package se.coredev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.model.Metadata;
import se.coredev.jpa.model.Role;
import se.coredev.jpa.model.User;

public final class Main {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

	}

	private static void save(User user) {

		EntityManager manager = factory.createEntityManager();
		
		if (user.getId() == null) {
			manager.persist(user);
		} else{
			manager.merge(user);
		}
	}

	private static void fetch() {
		EntityManager manager = factory.createEntityManager();

		Role role = new Role("admin");
		Metadata metadata = new Metadata("some value");
		User user = new User("master", role, metadata);

		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();

		manager = factory.createEntityManager();
		role = manager.createQuery("SELECT r FROM Role r JOIN FETCH r.users WHERE r.name = 'admin' ", Role.class)
		              .getSingleResult();

		manager.close();

		role.getUsers().forEach(u -> System.out.println(u.getUsername()));

	}


	private static void saveVsMerge() {
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		Role role = new Role("admin");
		Metadata metadata = new Metadata("some value");
		User user = new User("master", role, metadata);

		manager.persist(role);
		manager.persist(user);

		manager.getTransaction().commit();
		manager.close();

		// Fetch user
		manager = factory.createEntityManager();
		user = manager.find(User.class, 2L);
		manager.close();

		System.out.println(user.getUsername());
		System.out.println(user.getMetadata().getValue());

		// Update user
		user.getMetadata().setValue("some other value");
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		user = manager.merge(user);
		user.setUsername("new master");
		manager.getTransaction().commit();
		manager.close();

		// Fetch user
		manager = factory.createEntityManager();
		user = manager.find(User.class, 2L);
		manager.close();

		System.out.println(user.getUsername());
		System.out.println(user.getMetadata().getValue());

	}

}
