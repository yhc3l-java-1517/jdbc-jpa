package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Metadata extends AbstractEntity {

	@Column(nullable = false)
	private String value;

	protected Metadata() {
	}

	public Metadata(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
