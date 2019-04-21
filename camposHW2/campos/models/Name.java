package campos.models;

public class Name {
	private String lastName;
	private String firstName;
	private String gender;
	
	public Name(String lastName, String firstName, String gender) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Name [lastName=" + lastName + ", firstName=" + firstName + ", gender=" + gender + "]";
	}
	
//	@Override
//	public String toString() {
//		return lastName + ", " + firstName + ", " + gender;
//	}
}
