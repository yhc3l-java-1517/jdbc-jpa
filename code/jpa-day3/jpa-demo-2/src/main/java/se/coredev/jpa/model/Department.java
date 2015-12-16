package se.coredev.jpa.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToMany
	private Collection<Employee> employees;

	protected Department() {
	}

	public Department(String name) {
		this.name = name;
		this.employees = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public Department addEmployee(Employee employee) {
		employees.add(employee);
		return this;
	}

}
