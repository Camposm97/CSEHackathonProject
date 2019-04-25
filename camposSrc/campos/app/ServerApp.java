package campos.app;

import campos.net.Network;
import campos.stage.ServerWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class ServerApp extends Application {	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new ServerWindow(Network.PORT);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
