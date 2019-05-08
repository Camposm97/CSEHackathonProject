package campos.models;

@SuppressWarnings("serial")
public class Student extends Person {	
	private Major major;
	
	public Student(Name name, Major major) {
		super(name);
		this.major = major;
	}
	
	public Name getName() {
		return super.getName();
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + "major=" + major.toString() + "]";
	}
}
