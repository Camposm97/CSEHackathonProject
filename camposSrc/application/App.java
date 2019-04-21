package application;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.MainWindow;

/**
 * This is where the magic happens
 * @author Camposm97
 */
public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		new MainWindow(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
