package campos.models;

public class Student extends Person {	
	
	public Student(Name name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + "]";
	}
}
