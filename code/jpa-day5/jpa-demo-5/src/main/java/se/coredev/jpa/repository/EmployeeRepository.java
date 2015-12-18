package se.coredev.jpa.repository;

import java.util.List;

import se.coredev.jpa.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee> {

	List<Employee> getAll();
	Employee getByEmployeeNumber(String employeeNumber);
	
}
