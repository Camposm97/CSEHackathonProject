package cabrera.network.test;

import java.io.IOException;

public class HandleAClient implements Runnable {
	private User client;
	private UserList users;
	
	public HandleAClient(User client) {
		users.addUser(client);
		this.client = client;
	}
	
	@Override
	public void run() {
		try {
			client.getDos().writeUTF("Welcome to my server! You are " + client.getUsername());
			while (true) {
				client.getDos().writeUTF("Enter a username: ");
				String str = client.getDis().readUTF();
				if(!str.isEmpty()) {
					client.setUsername(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
