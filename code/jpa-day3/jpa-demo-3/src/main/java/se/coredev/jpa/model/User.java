package se.coredev.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	@GeneratedValue
	public Long id;

	@Column
	private String username;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Role role;

	@Embedded
	private Metadata metadata;

	protected User() {
	}

	public User(String username, Role role, Metadata metadata) {
		this.username = username;
		this.role = role;
		this.metadata = metadata;
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

	public Role getRole() {
		return role;
	}

	public Metadata getMetadata() {
		return metadata;
	}
}
