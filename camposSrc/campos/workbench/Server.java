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
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			String message = dis.readUTF();
			
			System.out.println(message);
			
			System.out.println("Closed Server");
			server.close();
		} catch (IOException e) {
			
		}
		
	}
}
