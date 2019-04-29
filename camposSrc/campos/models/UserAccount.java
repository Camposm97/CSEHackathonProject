package campos.models;

import java.io.Serializable;

import campos.io.DataLoader;
import campos.io.DataSaver;
import campos.util.Random;
import campos.util.UsernameUtil;

@SuppressWarnings("serial")
public class UserAccount implements Serializable, Comparable<UserAccount> {
	private static int idNumber = DataLoader.loadIdNumber();
	private String id;
	private Student s;
	private String username;
	private String password;
	
	public UserAccount(Student s) {
		this.id = String.valueOf(idNumber++);
		this.s = s;
		username = UsernameUtil.createUsername(s.getName(), id);
		password = Random.getPassword();
		DataSaver.saveIdNumber(idNumber);
	}
	
	public UserAccount(Student student, String username, String password) {
		this.id = String.valueOf(idNumber++);
		this.s = student;
		this.username = username;
		this.password = password;
		DataSaver.saveIdNumber(idNumber);
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
		return "UserAccount [id=" + id + ", s=" + s + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int compareTo(UserAccount o) {
		return username.compareTo(o.username);
	}
}
