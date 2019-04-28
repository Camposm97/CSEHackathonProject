package campos.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import campos.models.UserAccount;
import campos.scene.layout.LoginPane;
import campos.scene.layout.SignUpPane;
import javafx.application.Platform;
import javafx.scene.paint.Color;

public class ClientHandler implements Runnable {
	private Socket socket;
	private Object o;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ClientHandler(Socket socket, Object o) throws IOException {
		this.socket = socket;
		this.o = o;
		this.ois = new ObjectInputStream(socket.getInputStream());
		this.oos = new ObjectOutputStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		try {
			oos.writeObject(o);
			if (o instanceof LoginPane) {
				System.out.println("Verifying Credentials...");
				method();
			} else if (o instanceof SignUpPane) {
				System.out.println("Signing Up...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void method() throws IOException, ClassNotFoundException {
		LoginPane loginPane = (LoginPane) o;
//		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(loginPane.getUserAccount());
//		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		UserAccount user = (UserAccount) ois.readObject();
		
		Platform.runLater(() -> { 
			if (user != null) {
				// If !null, then login was a success, move to post feed and pass the UserAccount
				loginPane.getLblStatus().setText("Success! :D");
				loginPane.getLblStatus().setTextFill(Color.GREEN);
			} else { // Invalid Credentials
				loginPane.getLblStatus().setText("Failure :(");
				loginPane.getLblStatus().setTextFill(Color.RED);
			}
		});				
		oos.close();
		ois.close();
		socket.close();
	}
}
