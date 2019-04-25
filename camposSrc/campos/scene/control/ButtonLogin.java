package campos.scene.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import campos.models.UserAccount;
import campos.net.Network;
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
				Socket socket = new Socket(Network.HOST, Network.PORT);
				String username = loginPane.getTfUser().getText();
				String password = loginPane.getTfPassword().getText();
				UserAccount temp = new UserAccount(null, username, password);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				oos.writeObject(temp);
				boolean flag = ois.readBoolean();
				System.out.println(flag);
				oos.close();
				ois.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
