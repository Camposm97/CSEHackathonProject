package Ej.view;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ProfileGridPane {

	ProfileGridPane() {
		Stage stage = new Stage();
		GridPane pane = new GridPane();
		Button changePicture = new Button();
		Button setAppointment  = new Button();
		TextArea info = new TextArea();
		
		changePicture.setOnAction(e -> {
			FileChooser picture = new FileChooser();
			picture.getExtensionFilters().addAll(
			         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
			
			File selectedFile = picture.showOpenDialog(stage);
			 if (selectedFile != null) {
				 Background profilePic = picture;
			    changePicture.setBackground(profilePic);
			 }
		});
	}
}
