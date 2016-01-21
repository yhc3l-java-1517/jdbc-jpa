package se.coredev.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.coredev.sdj.model.Employee;
import se.coredev.sdj.repository.EmployeeRepository;

public final class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.sdj");
			context.refresh();
			
			EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
			Employee employee = employeeRepository.save(new Employee("Master", "Yoda", "1001"));

			// Add multiple employees to test findAll()
//			employeeRepository.save(new Employee("Master", "Yoda", "1001"));
//			employeeRepository.save(new Employee("Master", "Yoda", "1001"));
//			employeeRepository.save(new Employee("Master", "Yoda", "1001"));
//			employeeRepository.save(new Employee("Master", "Yoda", "1001"));
//			employeeRepository.save(new Employee("Master", "Yoda", "1001"));
//			employeeRepository.save(new Employee("Master", "Yoda", "1001"));
//			employeeRepository.save(new Employee("Master", "Yoda", "1001"));
//
//			employeeRepository.findAll().forEach(System.out::println);

			// Find one employee
			System.out.println(employeeRepository.findOne(employee.getId()));
			
			// Delete employee
			employeeRepository.delete(employee);
			
			// Find employee again 
			System.out.println(employeeRepository.findOne(employee.getId()));
			
		}
	}

}
