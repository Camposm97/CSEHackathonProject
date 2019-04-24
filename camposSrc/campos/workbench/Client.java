package campos.workbench;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private static final String host = "localhost";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			Socket socket = new Socket(host, 8000);
			System.out.println("Succesfully connected to " + socket.getInetAddress().getHostAddress());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("Enter your message: ");
			String message = in.nextLine();
			dos.writeUTF(message);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();
	}
}
