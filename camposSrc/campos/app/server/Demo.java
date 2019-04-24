package campos.app.server;

import campos.stage.ServerStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Demo extends Application {
	private static final int PORT = 8000;
	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new ServerStage(PORT);
		stage.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
