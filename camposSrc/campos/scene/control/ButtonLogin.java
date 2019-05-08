package campos.scene.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import campos.models.UserAccount;
import campos.net.IPv4;
import campos.net.SocketType;
import campos.scene.layout.LoginPane;
import campos.util.FXUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
				Platform.runLater(() -> {
					loginPane.getLblStatus().setText("Can't Connect to Server");
					loginPane.getLblStatus().setTextFill(Color.RED);
				});
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
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				oos.writeObject(SocketType.Login);
				oos.writeObject(loginPane.getUserAccount());
				UserAccount user = (UserAccount) ois.readObject();
				
				Platform.runLater(() -> { 
					if (user != null) {
						// If !null, then login was a success, move to post feed and pass the UserAccount
						loginPane.getLblStatus().setText("Success! :D");
						loginPane.getLblStatus().setTextFill(Color.GREEN);
						// change to post feed
						Stage stage = (Stage) loginPane.getScene().getWindow();
						stage.close();
						stage = new Stage();
						stage.setScene(new Scene(null));
						stage.show();
					} else { // Invalid Credentials
						loginPane.getLblStatus().setText("Failure :(");
						loginPane.getLblStatus().setTextFill(Color.RED);
					}
				});				
				oos.close();
				ois.close();
				socket.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
