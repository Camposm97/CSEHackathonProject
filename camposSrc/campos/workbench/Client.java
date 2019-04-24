package campos.workbench;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private static final String host = "25.5.191.107";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			Socket socket = new Socket(host, 8000);
			System.out.println("Succesfully connected to " + socket.getInetAddress().getHostAddress());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			while (true) {
				System.out.println("Enter your message: (enter stop to stop server)");
				String message = in.nextLine();
				dos.writeUTF(message);
				if (message.equals("stop")) {
					break;
				}
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();
	}
}
