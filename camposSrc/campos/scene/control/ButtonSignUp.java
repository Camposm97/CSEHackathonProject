package campos.scene.control;

import java.io.IOException;
import java.net.Socket;

import campos.net.ClientHandler;
import campos.net.IPv4;
import campos.util.FXUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonSignUp extends Button {
	public ButtonSignUp() {
		super("Sign Up");
		setPrefWidth(FXUtil.BT_WIDTH);
		setOnAction(new SignUpHandler());
	}
	
	private class SignUpHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			try {
				Socket socket = new Socket(IPv4.HOST, IPv4.PORT);
				new Thread(new ClientHandler(socket)).start();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}