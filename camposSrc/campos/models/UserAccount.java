package campos.models;

import java.io.Serializable;

import campos.util.Random;
import campos.util.UserAccountUtil;

public class UserAccount implements Serializable {
	private static int idNumber = 0;
	private String id;
	private Student student;
	private String username;
	private String password;
	
	public UserAccount(Student student) {
		id = String.valueOf(idNumber++);
		this.student = student;
		username = UserAccountUtil.createUsername(student.getName(), id);
		password = Random.getPassword();
	}
	
	public UserAccount(Student student, String username, String password) {
		id = String.valueOf(idNumber++);
		this.student = student;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
		return "UserAccount [id=" + id + ", student=" + student + ", username=" + username + ", password=" + password
				+ "]";
	}
}
