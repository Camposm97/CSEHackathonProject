package campos.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import campos.models.UserAccount;
import campos.scene.layout.ConsolePane;
import javafx.application.Platform;

public class ServerHandler implements Runnable {
	private Socket socket;
	private ConsolePane ta;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	/**
	 * We can have it where the client sends a number and that number means
	 * something. For instance, 0 can be for logging in, case 1: can be for signing
	 * up (add user to the bag) and case 2: can be for chat with another user.
	 * Either that or use enums to determine what to do with the client.
	 * 
	 * @param socket
	 * @param ta
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public ServerHandler(Socket socket, ConsolePane ta) throws IOException, ClassNotFoundException { // Constructor
		this.socket = socket;
		this.ta = ta;
		this.ois = new ObjectInputStream(socket.getInputStream());
		this.oos = new ObjectOutputStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		try {
			displayClient();
			resolveSocket();
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
	
	public void resolveSocket() throws ClassNotFoundException, IOException {
		SocketType socketType = (SocketType) ois.readObject();
		switch (socketType.toString()) {
		case "Login":
			verifyLogin();
			break;
		case "SignUp":
			signUp();
		}
	}

	public void verifyLogin() throws IOException, ClassNotFoundException {
		System.out.println("Verifying Credentials...");
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
	
	public void signUp() {
		System.out.println("Signing Up...(WIP)");
	}
}
