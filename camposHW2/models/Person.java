package models;

public abstract class Person {
	private static int idNumber = 0;
	private String id;
	protected Name name;
	
	public Person(Name name) {
		this.id = String.valueOf(idNumber++);
		this.name = name;
	}
	
	protected String getId() {
		return id;
	}
	
	protected void setName(Name name) {
		this.name = name;
	}
	
	protected Name getName() {
		return name;
	}
}
