package se.coredev.sdj.repository;

import org.springframework.data.repository.CrudRepository;

import se.coredev.sdj.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {}