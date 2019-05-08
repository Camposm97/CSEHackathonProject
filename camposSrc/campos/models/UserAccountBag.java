package campos.models;

import java.io.Serializable;
import java.util.TreeSet;

import campos.collections.UserAccountNameComparator;

@SuppressWarnings("serial")
public class UserAccountBag extends TreeSet<UserAccount> implements Serializable {
	public UserAccountBag() {
		super(new UserAccountNameComparator());
	}

	public UserAccount findByUsername(String username) {
		for (UserAccount user : this) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public boolean contains(String username) {
		if (findByUsername(username) != null)
			return true;
		return false;
	}

	public void display() {
		for (UserAccount u : this)
			System.out.println(u);
		System.out.println();
	}

	@Override
	public String toString() {
		String str = "";
		for (UserAccount u : this) {
			str += u + "\n";
		}
		return str;
	}
}
