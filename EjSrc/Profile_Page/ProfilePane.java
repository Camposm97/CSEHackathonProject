package Profile_Page;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ProfilePane extends Application{

	BorderPane mainPane = new BorderPane();
	Button appointment = new Button();
	Button picture = new Button();
	TextArea aboutMe = new TextArea();
	Button edit = new Button();
	Button done = new Button();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		appointment.setPrefSize(100, 25);
	//	mainPane.setLeft(appointment);
		
		
		Scene scene = new Scene(mainPane,400,400);
		stage.setScene(scene);
		stage.show();
	}

}
