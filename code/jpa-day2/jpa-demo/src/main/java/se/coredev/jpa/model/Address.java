package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(nullable = false)
	private String street;
	@Column(nullable = false)
	private String postal;
	@Column(nullable = false)
	private String zip;

	protected Address() {
	}

	public Address(String street, String postal, String zip) {
		this.street = street;
		this.postal = postal;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getPostal() {
		return postal;
	}

	public String getZip() {
		return zip;
	}

}
