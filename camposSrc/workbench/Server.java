package workbench;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import campos.net.IPv4;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(IPv4.PORT);
		System.out.println("Started server on " + new Date());
		new Thread(() -> {
			try {
				while (true) {
					Socket socket = server.accept();
					new Thread(() -> {
						try {
							ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
							System.out.println("Found a connection! ");
							System.out.println("Client says: " + ois.readUTF());
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
