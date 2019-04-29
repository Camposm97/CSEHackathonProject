package campos.models;

import java.io.Serializable;
import java.util.LinkedList;

import campos.io.DataLoader;
import campos.io.DataSaver;
import campos.util.Random;
import campos.util.UsernameUtil;
import doerz.model.Post;

@SuppressWarnings("serial")
public class UserAccount implements Serializable, Comparable<UserAccount> {
	private static int idNumber = DataLoader.loadIdNumber();
	private String id;
	private Student s;
	private String username;
	private String password;
	private UserAccountBag userFollowBag;
	private LinkedList<Post> postList;

	public UserAccount(Student s) { // For Auto-Generated UserAccounts
		this.id = String.valueOf(idNumber++);
		this.s = s;
		username = UsernameUtil.createUsername(s.getName(), id);
		password = Random.getPassword();
		DataSaver.saveIdNumber(idNumber);
	}

	public UserAccount(Student student, String username, String password) { // Default Constructor
		this.id = String.valueOf(idNumber++);
		this.s = student;
		this.username = username;
		this.password = password;
		DataSaver.saveIdNumber(idNumber);
		this.userFollowBag = new UserAccountBag();
		this.postList = new LinkedList<>();
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

	public UserAccountBag getUserFollowBag() {
		return userFollowBag;
	}
	

	public LinkedList<Post> getPostList() {
		return postList;
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
