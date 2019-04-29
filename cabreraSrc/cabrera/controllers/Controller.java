package cabrera.controllers;

import cabrera.models.FriendsList;
import cabrera.view.control.ChatPane;
import cabrera.view.control.FriendsPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
	
	static ObservableList<String> temp = FXCollections.observableArrayList();
	static FriendsList friends = new FriendsList();
	static ChatPane chatPane;
	static FriendsPane friendPane;

	public static ObservableList<String> populateFriends() {
		return friends.getUsersAsArrayList();
	}

	public static void updateTextArea(String userName) {
		chatPane.getText().clear();
		chatPane.getText().appendText(userName);
	}

	public static void setPanes(FriendsPane boxLeft, ChatPane boxRight) {
		chatPane = boxRight;
		friendPane = boxLeft;
	}
}
