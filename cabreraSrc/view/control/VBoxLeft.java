package view.control;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VBoxLeft {
	VBox box;
	
	public VBoxLeft() {
		 box = new VBox();
		
		TextField userSearch = new TextField();
		userSearch.setPromptText("Search By User Name");
		box.getChildren().add(userSearch);
		
		ListView<?> users = new ListView<>();
		box.getChildren().add(users);
		box.setSpacing(10);
	}

	public VBox getVBox() {
		return box;
	}
	
}
