package campos.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocket extends Socket {
	private SocketType type;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public MySocket(SocketType type) throws UnknownHostException, IOException {
		super(IPv4.HOST, IPv4.PORT);
		this.type = type;
		this.ois = new ObjectInputStream(getInputStream());
		this.oos = new ObjectOutputStream(getOutputStream());
	}
	
	public SocketType getType() {
		return type;
	}
	
	public ObjectInputStream getOis() {
		return ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}
	
	/**
	 * Closes all I/O streams and the socket itself
	 * @throws IOException
	 */
	public void closeAll() throws IOException {
		ois.close();
		oos.close();
		this.close();
	}
}
