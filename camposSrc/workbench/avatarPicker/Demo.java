package workbench.avatarPicker;

import campos.scene.layout.AvatarPicker;
import javafx.application.Application;
import javafx.stage.Stage;

public class Demo extends Application {
	@Override
	public void start(Stage stage) {
		AvatarPicker picker = new AvatarPicker();
		picker.showAndWait();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
