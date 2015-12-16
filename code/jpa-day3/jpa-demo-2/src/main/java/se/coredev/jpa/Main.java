package se.coredev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.model.Department;
import se.coredev.jpa.model.Employee;
import se.coredev.jpa.model.ParkingSpot;

public final class Main {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

//		EntityManager manager = factory.createEntityManager();
//		Department department = manager.find(Department.class, 1L);
//		department.getEmployees().forEach(employee -> System.out.println(employee.getEmployeeNumber()));
//		manager.close();
		
		addData();
	}

	private static void addData() {
		
		ParkingSpot parkingSpot = new ParkingSpot("AC-14");
		Employee employee1 = new Employee("Jones", "Watson", "1000", parkingSpot);
		Employee employee2 = new Employee("Luke", "Skywalker", "1001", parkingSpot);
		Employee employee3 = new Employee("Leia", "Skywalker", "1002", parkingSpot);

		Department department1 = new Department("Dev");
		Department department2 = new Department("DevOps");
		
		department1.addEmployee(employee1).addEmployee(employee2).addEmployee(employee3);
		
		department2.addEmployee(employee2);
		
		persistMany(department1, department2, parkingSpot, employee1, employee2, employee3);
	}

	private static void persistMany(Object... values) {
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		for (Object o : values) {
			manager.persist(o);
		}
		manager.getTransaction().commit();
	}

}
