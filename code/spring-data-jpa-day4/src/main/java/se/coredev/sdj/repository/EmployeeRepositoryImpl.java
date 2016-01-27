package se.coredev.sdj.repository;

import se.coredev.sdj.model.Employee;

public class EmployeeRepositoryImpl implements Log {

	@Override
	public void logEmployee(Employee employee) {
		System.out.println("Log: " + employee);
	}

}
