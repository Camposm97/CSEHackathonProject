package campos.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
	protected Name name;
	
	public Person(Name name) {
		this.name = name;
	}
	
	protected void setName(Name name) {
		this.name = name;
	}
	
	protected Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
