package campos.scene.control;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import campos.net.INet;
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
				Socket socket = new Socket(INet.HOST, INet.PORT);
				String username = loginPane.getTfUser().getText();
				String password = loginPane.getTfPassword().getText();
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(username);
				dos.writeUTF(password);
				
				dos.close();
				socket.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
