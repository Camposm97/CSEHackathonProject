package demo;

import javafx.application.Application;
import javafx.stage.Stage;
import view.Window;

public class Demo extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	
	public void start(Stage stage) throws Exception {
		new Window(stage);
	}

}
