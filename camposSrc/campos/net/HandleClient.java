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

	/**
	 * We can have it where the client sends a number and that number means
	 * something. For instance, 0 can be for logging in, case 1: can be for signing
	 * up (add user to the bag) and case 2: can be for chat with another user.
	 * @param socket
	 * @param ta
	 * @throws IOException
	 */
	public HandleClient(Socket socket, ConsolePane ta) throws IOException { // Constructor
		this.socket = socket;
		this.ta = ta;
	}

	@Override
	public void run() {
		try {
			displayClient();
			verifyLogin();
		} catch (Exception e) {
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
		boolean userExists = ta.getServer().getUserBag().contains(temp);

		Platform.runLater(() -> {
			ta.appendText("Does " + temp.getUsername() + " exist? " + userExists + "\n");
			ta.appendText("\n");
		});

		if (userExists) {
			UserAccount user = ta.getServer().getUserBag().findByUsername(temp.getUsername());
			if (user.getPassword().equals(temp.getPassword())) {
				oos.writeObject(user);
			} else {
				oos.writeObject(null);
			}
		} else {
			oos.writeObject(null);
		}
		ois.close();
		oos.close();
		socket.close();
	}

}
