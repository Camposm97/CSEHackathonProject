package cabrera.models;

import campos.models.UserAccountBag;
import campos.util.UserAccountFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FriendsList {
	private ObservableList<String> friendList;
	private final int amount = 100;
	
	public FriendsList() {
		friendList = FXCollections.observableArrayList();
		UserAccountBag bag = UserAccountFactory.loadUserAccountBag(amount);
		for(int i = 0; i < amount; i++) {
			friendList.add(bag.get(i).getUsername());
		}
	}

	public ObservableList<String> getUsersAsArrayList() {
		return friendList;
	}
	
	
}
