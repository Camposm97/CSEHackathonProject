package doerz.model;

import java.util.Date;

import campos.models.UserAccount;

public class Post {
	private static int idNumber = 0;
	private String id;
	private Message message;
	private UserAccount author;
	private Date date;

	public Post(Message message, UserAccount author) {
		this.id = String.valueOf(idNumber++);
		this.message = message;
		this.author = author;
		date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public UserAccount getAuthor() {
		return author;
	}

	public String getMessage() {
		return message.getMessage();
	}

	public void setMessage(String message) {
		this.message.setMessage(message);
	}
	
	public double getHeight() {
		return message.getHeight();
	}

	@Override
	public String toString() {
		return "Post [id:" + id + ", msg:" + message + ", time:" + date +"]";
	}
}
