package doerz.model;

import java.util.Date;

import campos.models.UserAccount;

public class Post extends Message implements Comparable<Post> {
	private static int idNumber = 0;
	private String id;
	private UserAccount author;
	private Date date;

	public Post(String message, UserAccount author) {
		super(message);
		this.id = String.valueOf(idNumber++);
		this.author = author;
		date = new Date();
	}
	
	public Post(String message, double height, UserAccount author) {
		super(message, height);
		this.id = String.valueOf(idNumber++);
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
		return super.getMessage();
	}

	public void setMessage(String message) {
		super.setMessage(message);
	}
	
	public double getHeight() {
		return super.getHeight();
	}

	@Override
	public String toString() {
		return "Post [id:" + id + ", msg:" + super.getMessage() + ", time:" + date +"]";
	}

	@Override
	public int compareTo(Post p) {
		return date.compareTo(p.date);
	}
}
