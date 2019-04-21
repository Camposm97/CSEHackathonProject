package campos.models;

import campos.util.Random;

public class Student extends Person {
	private double gpa;
	
	public Student(Name name, double gpa) {
		super(name);
		this.gpa = gpa;
	}
	
	public Student(Name name) {
		super(name);
		this.gpa = Random.getGpa();
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [gpa=" + String.format("%1.1f", gpa) + ", name=" + name + "]";
	}
}
