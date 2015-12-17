package se.coredev.jpa.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Employee.GetAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.GetByEmployeeNumber", query = "SELECT e FROM Employee e WHERE e.employeeNumber = :employeeNumber")
})
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

	@ElementCollection
	private Map<Integer, String> notes;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, String employeeNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.notes = new HashMap<>();
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

	public Employee addNote(String note, Integer priority) {
		notes.put(priority, note);
		return this;
	}

	public Map<Integer, String> getNotes() {
		return notes;
	}
}
