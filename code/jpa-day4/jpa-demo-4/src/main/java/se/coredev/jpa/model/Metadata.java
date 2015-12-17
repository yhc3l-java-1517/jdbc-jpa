package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Metadata {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String value;

	protected Metadata() {
	}

	public Metadata(String value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

}