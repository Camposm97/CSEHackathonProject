package campos.app;

import campos.net.IPv4;
import campos.stage.ServerWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class ServerApp extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage = new ServerWindow(IPv4.PORT);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
