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
<<<<<<< HEAD
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			String message = dis.readUTF();
			
			System.out.println(message);
			
			System.out.println("Closed Server");
=======
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
>>>>>>> 1156bb704384857af50f90bd8b5b5e9e477d7d94
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
