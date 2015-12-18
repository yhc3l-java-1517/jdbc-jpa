package se.coredev.jpa.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Employee.GetAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.GetByEmployeeNumber", query = "SELECT e FROM Employee e WHERE e.employeeNumber = :employeeNumber")
})
public class Employee extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String employeeNumber;

	protected Employee(){}
	
	public Employee(String firstName, String lastName, String employeeNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	@Override
	public String toString() {
		return getId() + ", " + firstName + ", " + lastName + ", " + employeeNumber;
	}

}
