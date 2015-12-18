package se.coredev.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.model.Employee;
import se.coredev.jpa.model.Metadata;
import se.coredev.jpa.repository.EmployeeRepository;
import se.coredev.jpa.repository.JpaEmployeeRepository;
import se.coredev.jpa.repository.JpaMetadataRepository;
import se.coredev.jpa.repository.MetadataRepository;

public final class Main {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {
		
		EmployeeRepository employeeRepository = new JpaEmployeeRepository(factory);
		
		employeeRepository.saveOrUpdate(new Employee("master1", "anca1", "1001"));
		employeeRepository.saveOrUpdate(new Employee("master2", "anca2", "1002"));
		employeeRepository.saveOrUpdate(new Employee("master3", "anca3", "1003"));
		
		employeeRepository.getAll().forEach(System.out::println);
		
//		MetadataRepository metadataRepository = new JpaMetadataRepository(factory);
//		Metadata metadata = new Metadata("value");
//		
//		metadataRepository.saveOrUpdate(metadata);
		
	}

}
