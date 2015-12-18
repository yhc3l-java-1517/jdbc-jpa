package se.coredev.jpa.repository;

import static java.util.function.Function.identity;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import se.coredev.jpa.model.Employee;

public final class JpaEmployeeRepository extends AbstractJpaRepository<Employee> implements EmployeeRepository {

	public JpaEmployeeRepository(EntityManagerFactory factory) {
		super(factory, Employee.class);
	}

	@Override
	public List<Employee> getAll() {
		return query("Employee.GetAll", identity());
	}

	@Override
	public Employee getByEmployeeNumber(String employeeNumber) {
		return querySingle("Employee.GetByEmployeeNumber", query -> query.setParameter("employeeNumber", employeeNumber));
	}


}
