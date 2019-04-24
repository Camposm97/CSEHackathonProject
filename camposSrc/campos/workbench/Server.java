package campos.workbench;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			
			System.out.println("Awaiting connection...");
			Socket socket = server.accept();
			System.out.println("Found a connection!");
			while (true) {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				
				String message = dis.readUTF();
				
				if (message.equals("stop")) {
					System.out.println("Closing Server...");
					break;
				}
				
				System.out.println("User said: " + message);				
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
