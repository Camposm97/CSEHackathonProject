package cabrera.view;

import cabrera.view.control.VBoxLeft;
import cabrera.view.control.VBoxRight;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Window {
	
	public Window(Stage stage) {
		SplitPane root = new SplitPane();
		root.setStyle("-fx-background-color: #B0C4DE");
		
		VBoxLeft boxLeft = new VBoxLeft();
		VBoxRight boxRight = new VBoxRight();
		
		root.getItems().add(boxLeft.getVBox());
		root.getItems().add(boxRight.getVBox());
		root.setPadding(new Insets(20));

		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.setTitle("Connect Chat");
		stage.setResizable(false);
		stage.addEventHandler(KeyEvent.KEY_PRESSED, e ->{
			if(e.getCode() == KeyCode.ESCAPE) {
				Platform.exit();
			}
		});
		
		root.setDividerPositions(0.35);
		stage.show();
	}
}
