package se.coredev.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.coredev.sdj.repository.EmployeeRepository;

public final class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.sdj");
			context.refresh();

			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
//			repository.save(new Employee("Darth", "Vader", "2002"));
//			repository.findByFirstNameAndLastName("Darth", "Vader").forEach(System.out::println);
//			repository.findByLastNameContaining("YO").forEach(System.out::println);
//			System.out.println(repository.countByLastName("Yoda"));
//			repository.save(new Employee("Master", "Yoda", "1001", new Address("street", "postal", "zip")));
//			System.out.println(repository.findByAddressStreet("street"));
			
			repository.removeByLastName("Yoda").forEach(System.out::println);
			
			
			
//			EmployeeService service = context.getBean(EmployeeService.class);
//			System.out.println(service.save(new Employee("Master", "Yoda", "1001")));
						
		}
	}

}
