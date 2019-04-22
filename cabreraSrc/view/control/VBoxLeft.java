package view.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VBoxLeft {
	VBox box;
	
	public VBoxLeft() {
		 box = new VBox();
		
		TextField userSearch = new TextField();
		userSearch.setPromptText("Search By User Name");
		box.getChildren().add(userSearch);
		
		Label friendL = new Label("Friends");
		friendL.setFont(new Font(15));
		box.getChildren().add(friendL);
	
		ObservableList<String> friends = FXCollections.observableArrayList();
		friends.addAll("Rob", "EJ", "Michael", "Richard");
		ListView<String> users = new ListView<>(friends);
		
		box.getChildren().add(users);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		box.setPadding(new Insets(0,20,0,0));
	}

	public VBox getVBox() {
		return box;
	}
	
}
