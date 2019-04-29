package cabrera.models;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FriendsList {
	//private ObservableList<String> friendList;
	private final int amount = 100;
	ObservableList<String> friendList;
	
	public FriendsList() {
		friendList = FXCollections.observableArrayList();
		friendList.addListener(new InvalidationListener() {
			
			public void invalidated(Observable observable) {
				System.out.println("List Invalidated");
			}
			
		});
		
		friendList.add("EJ");
		friendList.add("Michael");
		friendList.add("Richard");
	}

	public ObservableList<String> getUsersAsArrayList() {
		return friendList;
	}
	
	
}
