package cabrera.demo;

import cabrera.view.Window;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 * LUL
 * @author Camposm97
 */
public class Demo extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	
	public void start(Stage stage) throws Exception {
		new Window(stage);
	}

}
