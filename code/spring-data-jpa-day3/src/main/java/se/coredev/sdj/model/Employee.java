package se.coredev.sdj.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
//@NamedQuery(name="Employee.getByNumber", query="select e from Employee e where e.employeeNumber = ?1")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String employeeNumber;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Address address;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, String employeeNumber, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
