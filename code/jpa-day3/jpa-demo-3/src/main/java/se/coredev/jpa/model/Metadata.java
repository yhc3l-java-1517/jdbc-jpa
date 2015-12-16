package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Metadata {

	@Column
	private String value;

	protected Metadata() {
	}

	public Metadata(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
