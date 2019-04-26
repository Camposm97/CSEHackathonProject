package campos.scene.control;

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
//				socket.getOos().writeObject(
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						oos.writeObject(new UserAccount(null, loginPane.getTfUser().getText(), loginPane.getTfPassword().getText()));
						oos.flush();
//				UserAccount user = (UserAccount) socket.getOis().readObject();
//				oos.close();
//				socket.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
