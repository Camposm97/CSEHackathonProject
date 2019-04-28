package cabrera.view.control;

import cabrera.controllers.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FriendsPane {
	VBox box;
	ListView<String> users;

	public FriendsPane() {
		box = new VBox();
		
		TextField userSearch = new TextField();
		userSearch.setPromptText("Search By User Name");
		box.getChildren().add(userSearch);
		
		users = new ListView<>(Controller.populateFriends());
		box.getChildren().add(users);
		
		
		userSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.isEmpty()) {
				box.getChildren().remove(users);
				users = new ListView<>(Controller.checkUser(newValue));
				box.getChildren().add(users);
			} else {
				box.getChildren().remove(users);
				users = new ListView<>(Controller.populateFriends());
				box.getChildren().add(users);
			}
		});
		
		Label friendL = new Label("Friends");
		friendL.setFont(new Font(15));
		box.getChildren().add(friendL);
		
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		box.setPadding(new Insets(0, 20, 0, 0));
	}

	public VBox getVBox() {
		return box;
	}

}
