package model;

public class User {
//	private Image profileImage;
	private String username;
	private Name name;
	private String status;
	
	public User(String username, Name name, String status) {
		this.username = username;
		this.name = name;
		this.status = status;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
