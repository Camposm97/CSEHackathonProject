package doerz.demo;

import campos.models.UserAccount;
import doerz.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;
import util.Dummy;

/**
 * 
 * @author rjdoerz
 * 
 * Start feed from here.
 *
 */

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		UserAccount user = Dummy.getDummyAcc("defaultUser");
		new MainWindow(primaryStage, user);
	}

}
