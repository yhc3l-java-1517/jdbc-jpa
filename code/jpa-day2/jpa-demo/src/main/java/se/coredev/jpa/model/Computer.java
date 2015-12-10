package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Computer {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String model;

	@Column(nullable = false, unique = true)
	private String number;

	protected Computer() {
	}

	public Computer(String model, String number) {
		this.model = model;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getNumber() {
		return number;
	}

}
