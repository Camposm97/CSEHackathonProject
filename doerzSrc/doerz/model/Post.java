package doerz.model;

import campos.models.UserAccount;

public class Post {
	private static int idNumber = 0;
	private String id;
	private String message;
	private UserAccount author;

	public Post(String message, UserAccount author) {
		this.id = String.valueOf(idNumber++);
		this.message = message;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public UserAccount getAuthor() {
		return author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Post [id:" + id + ", msg:" + message + "]";
	}
}
