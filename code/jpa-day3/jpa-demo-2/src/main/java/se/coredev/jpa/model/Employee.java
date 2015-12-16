package se.coredev.jpa.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String employeeNumber;

	@ManyToMany(mappedBy = "employees")
	private Collection<Department> departments;

	@OneToOne
	private ParkingSpot parkingSpot;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, String employeeNumber, ParkingSpot parkingSpot) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.parkingSpot = parkingSpot;
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
	
	public Collection<Department> getDepartments() {
		return departments;
	}
	
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
}
