package workbench;

import java.io.ObjectOutputStream;
import java.net.Socket;

import campos.net.IPv4;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(IPv4.HOST, IPv4.PORT);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeUTF("Hello from " + socket.getInetAddress().getHostAddress());
		socket.close();
	}
}
