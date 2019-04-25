package campos.app;

import java.io.IOException;
import java.net.Socket;

import campos.net.INet;
import campos.stage.LoginStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class LoginApp extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage = new LoginStage();
		stage.show();
	}

	public static void main(String[] args) {
//		launch(args);
		try {
			Socket socket = new Socket(INet.LOCAL_HOST, INet.PORT);
			System.out.println(socket.getInetAddress().getHostAddress());
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
