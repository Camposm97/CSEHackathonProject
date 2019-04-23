package cabrera.controllers;

import cabrera.models.FriendsList;
import cabrera.util.CheckUserNameUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
	
	static ObservableList<String> temp = FXCollections.observableArrayList();
	static FriendsList friends = new FriendsList();

	public static ObservableList<String> populateFriends() {
		return friends.getUsersAsArrayList();
	}

	public static ObservableList<String> checkUser(String input) {
		temp = friends.getUsersAsArrayList();
		return CheckUserNameUtil.filterList(temp, input);
	}
}
