package doerz.demo;

import doerz.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author rjdoerz
 * 
 * Start feed from here.
 *
 */

public class FeedDemo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new MainWindow(primaryStage);
	}

}
