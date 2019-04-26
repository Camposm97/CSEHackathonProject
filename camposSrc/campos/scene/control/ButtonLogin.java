package campos.scene.control;

import campos.models.UserAccount;
import campos.net.MySocket;
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
				MySocket socket = new MySocket();
				socket.getOos().writeObject(
						new UserAccount(null, loginPane.getTfUser().getText(), loginPane.getTfPassword().getText()));
//				UserAccount user = (UserAccount) socket.getOis().readObject();
				socket.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
