package campos.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocket extends Socket {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public MySocket() throws UnknownHostException, IOException {
		super(IPv4.HOST, IPv4.PORT);
		this.ois = new ObjectInputStream(getInputStream());
		this.oos = new ObjectOutputStream(getOutputStream());
	}
	
	public ObjectInputStream getOis() {
		return ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}
}
