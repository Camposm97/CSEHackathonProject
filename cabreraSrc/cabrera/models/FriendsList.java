package cabrera.models;

import cabrera.controllers.Controller;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class FriendsList {
	//private ObservableList<String> friendList;
	private final int amount = 100;
	ObservableList<String> friendList;
	
	public FriendsList() {
		friendList = FXCollections.observableArrayList();
		friendList.addListener(new ListChangeListener<String>() {

			public void onChanged(Change c) {
				System.out.println(c.toString());
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
