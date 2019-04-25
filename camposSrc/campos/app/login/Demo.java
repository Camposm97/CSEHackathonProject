package campos.app.login;

import campos.stage.LoginStage;
import javafx.application.Application;
import javafx.stage.Stage;


public class Demo extends Application {	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new LoginStage();
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
