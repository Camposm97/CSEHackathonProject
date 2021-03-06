package campos.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;

import campos.io.DataLoader;
import campos.models.UserAccountBag;

public class MyServerSocket extends ServerSocket {
	private UserAccountBag userBag;
	private LinkedList<UserSocket> socketList;
		
	public MyServerSocket(int port) throws IOException {
		super(port);
		this.userBag = DataLoader.loadUserBag();
	}
	
	public UserAccountBag getUserBag() {
		return userBag;
	}
}
