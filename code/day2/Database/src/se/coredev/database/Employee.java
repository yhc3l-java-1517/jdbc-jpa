package se.coredev.database;

public final class Employee {

	private final Long id;
	private final String firstName;
	private final String lastName;
	private final String employeeNumber;

	public Employee(Long id, String firstName, String lastName, String employeeNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
	}

	public Long getId() {
		return id;
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
		return id +  ", " + firstName + ", " + lastName + ", " + employeeNumber;
	}

}
