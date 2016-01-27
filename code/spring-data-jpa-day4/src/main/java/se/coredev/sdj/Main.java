package se.coredev.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.coredev.sdj.model.Address;
import se.coredev.sdj.model.Employee;
import se.coredev.sdj.repository.EmployeeRepository;

public final class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.sdj");
			context.refresh();

			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
			
			Address address = new Address("street2", "postal2", "zip2"); 			
			Employee employee = new Employee("Master", "Yoda", "1001", address);
			
			repository.logEmployee(employee);
			
			
			
//			Address address1 = new Address("street1", "postal1", "zip1"); // 1
//			Address address2 = new Address("street2", "postal2", "zip2"); // 2
//			
//			Employee employee1 = new Employee("Master", "Yoda", "1001", address1); // 3
//			Employee employee2 = new Employee("Master", "Yoda", "1001", address2); // 4	
//
//			EmployeeService service = context.getBean(EmployeeService.class);
//			service.save(employee1);
//			service.save(employee2);

		}
	}
}
