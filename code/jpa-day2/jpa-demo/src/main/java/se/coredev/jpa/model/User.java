package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true, nullable = false)
	private String username;
	@Embedded
	private Address address;
	@ManyToOne
	@JoinColumn(name = "computerId")
	private Computer computer;
	@ManyToOne	
	private Role role;

	protected User() {
	}

	public User(String username, Address address, Computer computer, Role role) {
		this.username = username;
		this.address = address;
		this.computer = computer;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Address getAddress() {
		return address;
	}

	public Computer getComputer() {
		return computer;
	}

	public Role getRole() {
		return role;
	}
}
