package campos.models;

public class Student extends Person {	
	private Major major;
	
	public Student(Name name, Major major) {
		super(name);
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + "major=" + major.toString() + "]";
	}
}
