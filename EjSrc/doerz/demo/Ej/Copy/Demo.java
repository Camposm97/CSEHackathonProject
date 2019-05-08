package doerz.demo.Ej.Copy;

import campos.models.UserAccount;
import doerz.view.Ej.copy.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;
import util.Dummy;

/**
 * 
 * @author rjdoerz
 * 
 * Demo the mainWindow functionality.
 *
 */

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		UserAccount user = Dummy.getDummyAcc("defaultUser");
		new MainWindow(user);
	}

}
