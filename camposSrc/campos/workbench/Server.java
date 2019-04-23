package campos.workbench;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(1, 50, InetAddress.getByName("localhost"));
		System.out.println("Host Name: " + ss.getInetAddress().getHostName());
		System.out.println("Port: " + ss.getLocalPort());
		
		ss.setSoTimeout(10000);
		Socket s;
		
		while (true) {
			try {
				s = ss.accept();

				System.out.println("Just connected to " + s.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(s.getInputStream());

				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				out.writeUTF("Thank you for connecting to " + s.getLocalSocketAddress() + "\nGoodbye!");
				s.close();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ss.close();
	}
}
