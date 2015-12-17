package se.coredev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.model.Employee;

public final class Main {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {
		
		Employee employee = new Employee("firstName1", "lastName1", "1001").addNote("Remember to...", 2).addNote("Don't forget ...", 1);
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();

		manager.persist(employee);
		
		manager.getTransaction().commit();
		manager.close();

		manager = factory.createEntityManager();
	}

}
