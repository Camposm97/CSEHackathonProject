package campos.scene.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.omg.CORBA.DataInputStream;

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
			UserAccount temp = new UserAccount(null, loginPane.getTfUser().getText(), loginPane.getTfPassword().getText());
			try {
				Socket socket = new Socket(IPv4.LOCAL_HOST, IPv4.PORT);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(temp);
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
