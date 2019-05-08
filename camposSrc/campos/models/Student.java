package campos.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student extends Person implements Serializable {	
	private Major major;
	
	public Student(Name name, Major major) {
		super(name);
		this.major = major;
	}
	
	public Name getName() {
		return super.getName();
	}
	
	public Major getMajor() {
		return major;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + "major=" + major.toString() + "]";
	}
}
