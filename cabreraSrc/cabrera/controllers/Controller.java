package cabrera.controllers;


import cabrera.models.ChatLogs;
import cabrera.models.FriendsList;
import cabrera.view.control.ChatPane;
import cabrera.view.control.FriendsPane;
import javafx.collections.ObservableList;

public class Controller {

	static FriendsList friends = new FriendsList();
	static ChatPane chatPane;
	static FriendsPane friendPane;
	static String currentFriend;
	static ChatLogs chatLog = new ChatLogs(100);

	public static ObservableList<String> populateFriends() {
		return friends.getUsersAsArrayList();
	}

	public static void updateSelectedFriend(String selectedItem) {
		currentFriend = selectedItem;
		chatPane.getLabel().setText("Chatting With: " + currentFriend);
		chatPane.getText().setText(chatLog.findLog(currentFriend).getLog());
	}
	
	public static void setPanes(FriendsPane boxLeft, ChatPane boxRight) {
		chatPane = boxRight;
		friendPane = boxLeft;
	}

	public static void addLog(String userName) {
		chatLog.addLog(userName);
	}

	public static void addMessage(String message) {
		chatLog.addToLog(message, currentFriend);
	}

}
