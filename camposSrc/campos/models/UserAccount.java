package campos.models;

import java.io.Serializable;

import campos.util.Random;
import campos.util.UserAccountUtil;

@SuppressWarnings("serial")
public class UserAccount implements Serializable, Comparable<UserAccount> {
	private static int idNumber = 0;
	private String id;
	private Student s;
	private String username;
	private String password;
	
	public UserAccount(Student s) {
		id = String.valueOf(idNumber++);
		this.s = s;
		username = UserAccountUtil.createUsername(s.getName(), id);
		password = Random.getPassword();
	}
	
	public UserAccount(Student student, String username, String password) {
		id = String.valueOf(idNumber++);
		this.s = student;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public Student getStudent() {
		return s;
	}

	public void setStudent(Student student) {
		this.s = student;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", s=" + s + ", username=" + username + ", password=" + password
				+ "]";
	}

	@Override
	public int compareTo(UserAccount o) {
		return username.compareTo(o.username);
	}
}
