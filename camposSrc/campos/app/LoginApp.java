package campos.app;

import java.net.Socket;

import campos.net.IPv4;
import campos.stage.LoginWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class LoginApp extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage = new LoginWindow();
		stage.show();
	}

	public static void main(String[] args) throws Exception {
//		launch(args);
		Socket socket = new Socket(IPv4.HOST, IPv4.PORT);
		System.out.println("Is connected? " + socket.isConnected());
	}
}
