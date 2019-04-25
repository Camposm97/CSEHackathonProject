package campos.app;

import campos.net.INet;
import campos.stage.ServerStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class ServerApp extends Application {	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new ServerStage(INet.PORT);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
