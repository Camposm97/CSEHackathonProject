package cabrera.demo;

import cabrera.controllers.Controller;
import cabrera.view.Window;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Cabrerar98
 */
public class Demo extends Application {

	public static void main(String[] args) {
		Controller.addToList("EJ");
		Controller.addToList("Richard");
		Controller.addToList("Michael");
		
		Application.launch(args);
	}

	
	public void start(Stage stage) throws Exception {
		new Window(stage);
	}

}
