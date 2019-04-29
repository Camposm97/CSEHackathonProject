package doerz.model;

public class Message {
	private String message;
	private double height;
	
	public Message(String message, double height) {
		this.message = message;
		this.height = height;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return message;
	}
	
}
