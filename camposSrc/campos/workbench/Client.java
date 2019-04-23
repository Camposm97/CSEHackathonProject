package campos.workbench;

import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet.getHostAddress());
		Socket s = new Socket("localhost", 1);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeUTF("Hello World!");
		dos.flush();
		dos.close();
		s.close();
	}
}
