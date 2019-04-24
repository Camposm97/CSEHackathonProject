package campos.workbench;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	private static final int DEFAULT_PORT = 8000;
	private String username;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public Client (String username, Socket socket) throws IOException {
		this.username = username;
		this.socket = socket;
		this.dis = new DataInputStream(socket.getInputStream());
		this.dos = new DataOutputStream(socket.getOutputStream());
	}
	
	public Client(String username, String ip) throws IOException {
		this.username = username;
		this.socket = new Socket(ip, DEFAULT_PORT);
		this.dis = new DataInputStream(socket.getInputStream());
		this.dos = new DataOutputStream(socket.getOutputStream());
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public DataOutputStream getDos() {
		return dos;
	}
	
	public DataInputStream getDis() {
		return dis;
	}
}
