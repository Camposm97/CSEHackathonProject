package campos.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import campos.models.UserAccount;
import campos.scene.layout.ConsolePane;
import javafx.application.Platform;

public class HandleClient implements Runnable {
	private Socket socket;
	private ConsolePane ta;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public HandleClient(Socket socket, ConsolePane ta) throws IOException { // Constructor
		this.socket = socket;
		this.ta = ta;
	}

	@Override
	public void run() {
		try {
			displayClient();
			verifyLogin();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void displayClient() {
		InetAddress inet = socket.getInetAddress();
		ta.appendText("Connected [");
		ta.appendText("Host Name: " + inet.getHostName() + " | ");
		ta.appendText("IP: " + inet.getHostAddress() + "]\n");
	}

	public void verifyLogin() throws IOException, ClassNotFoundException {
		this.ois = new ObjectInputStream(socket.getInputStream());
		this.oos = new ObjectOutputStream(socket.getOutputStream());
		UserAccount temp = (UserAccount) ois.readObject();
		boolean exists = ta.getServer().getUserBag().contains(temp);
		
		Platform.runLater(() -> {
			ta.appendText("Does " + temp.getUsername() + " exist? " + exists + "\n");
			ta.appendText("\n");
		});

		if (exists)
			oos.writeObject(ta.getServer().getUserBag().findByUsername(temp.getUsername()));
		else
			oos.writeObject(null);
		ois.close();
		oos.close();
		socket.close();
	}

}
