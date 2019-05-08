package campos.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Name implements Serializable {
	private String lastName;
	private String firstName;
	private Gender gender;
	
	public Name(String lastName, String firstName, Gender gender) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
