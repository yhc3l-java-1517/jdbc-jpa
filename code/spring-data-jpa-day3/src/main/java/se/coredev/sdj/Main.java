package se.coredev.sdj;

import java.util.List;

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
//			addData(repository, 20);
			
//			Page<Employee> result = repository.findAll(new PageRequest(0, 10, Direction.DESC, "employeeNumber", "lastName"));
//			Slice<Employee> result = repository.findByLastNameLike("lastname1%", new PageRequest(0, 5));
			List<Employee> result = repository.getByNumber("1");
			
//			while(result.hasNext()) {
//				System.out.println("--------- Page " + result.getNumber() + " ----------");
//				result.forEach(System.out::println);
//				result = repository.findAll(result.nextPageable());
//			}
//			System.out.println("--------- Page " + result.getNumber() + " ----------");
			result.forEach(System.out::println);
			
		}
	}

	private static void addData(EmployeeRepository repository, int count) {
		for (int i = 0; i < count; i++) {
			Address address = new Address("street" + i, "postal" + i, "zip" + i);
			Employee employee = new Employee("firstName" + i, "lastName" + i, "" + i, address);
			repository.save(employee);
		}
	}

}
