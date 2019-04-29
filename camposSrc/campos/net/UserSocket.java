package campos.net;

import java.net.Socket;
import java.util.LinkedList;

import campos.models.UserAccount;

public class UserSocket implements Comparable<UserSocket> {
	private String username;
	private Socket socket;
	
	public UserSocket(String username) {
		this.username = username;
	}
	
	public UserSocket(String username, Socket socket) {
		this.username = username;
		this.socket = socket;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public int compareTo(UserSocket u) {
		return username.compareTo(u.username);
	}
}
