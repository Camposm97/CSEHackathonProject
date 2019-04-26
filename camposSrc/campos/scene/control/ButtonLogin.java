package campos.scene.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import campos.models.UserAccount;
import campos.net.IPv4;
import campos.scene.layout.LoginPane;
import campos.util.FXUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonLogin extends Button {
	private LoginPane loginPane;

	public ButtonLogin(LoginPane loginPane) {
		super("Login");
		this.loginPane = loginPane;
		this.setPrefWidth(FXUtil.BT_WIDTH);
		this.setOnAction(new LoginHandler());
	}

	private class LoginHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			try {
				Socket socket = new Socket(IPv4.HOST, IPv4.PORT);
				new Thread(new SocketHandler(socket)).start();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private class SocketHandler implements Runnable {
		private Socket socket;

		public SocketHandler(Socket socket) { // Constructor
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(loginPane.getUserAccount());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				UserAccount user = (UserAccount) ois.readObject();
				if (user != null) {
					System.out.println("Valid!");
					System.out.println(user);
				} else {
					System.out.println("Invalid!");
					System.out.println(user);
				}
				oos.close();
				ois.close();
				socket.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
