package campos.workbench;

import java.io.IOException;

public class HandleAClient implements Runnable {
	private Client client;
	
	public HandleAClient(Client client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		try {
			client.getDos().writeUTF("Welcome to my server! You are " + client.getUsername());
			while (true) {
				client.getDos().writeUTF("Is you name Rob? (Yes/No) ");
				String str = client.getDis().readUTF();
				if (str.equalsIgnoreCase("yes")) {
					client.getDos().writeUTF("LOL");
				} else if (str.equalsIgnoreCase("no")){
					client.getDos().writeUTF("Aw, okay...");
				} else {
					client.getDos().writeUTF("Goodbye.");;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
