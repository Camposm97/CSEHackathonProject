package cabrera.network.test;

import java.util.LinkedList;

public class UserList {
	private LinkedList<User> ll;

	public UserList() {
		ll = new LinkedList<User>();
	}
	public String addUser(User user) {
		ll.add(user);
		return user.toString() + " has been added";
	}
}
