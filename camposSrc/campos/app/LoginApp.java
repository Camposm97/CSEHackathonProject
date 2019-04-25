package campos.app;

import campos.stage.LoginWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class LoginApp extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage = new LoginWindow();
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
