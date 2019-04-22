package view;

import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import view.control.VBoxLeft;
import view.control.VBoxRight;

public class Window {
	
	public Window(Stage stage) {
		SplitPane root = new SplitPane();
		
		VBoxLeft boxLeft = new VBoxLeft();
		VBoxRight boxRight = new VBoxRight();
		
		root.getItems().add(boxLeft.getVBox());
		root.getItems().add(boxRight.getVBox());
		
		
		
		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		
		root.setDividerPositions(0.35);
		stage.show();
	}
}
