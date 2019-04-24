package campos.workbench;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		new Thread(() -> {
			Scanner input = new Scanner(System.in);
			ServerSocket server = null;
			try {
				server = new ServerSocket(8000);
				int i = 0;
				while (true) {
					System.out.println("Waiting for a connection...");	
					Socket socket = server.accept();
					System.out.println("Found a connection!");	
					Client client = new Client("Client #" + (i++), socket);
					new Thread(new HandleAClient(client)).start();
					System.out.println("Command: ");
					String command = input.next();
					if (command.equals("exit")) {
						break;
					}
				}
				input.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
