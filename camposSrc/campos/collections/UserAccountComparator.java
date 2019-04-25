package campos.collections;

import java.util.Comparator;

import campos.models.UserAccount;

public class UserAccountComparator implements Comparator<UserAccount> {

	@Override
	public int compare(UserAccount u1, UserAccount u2) {
		return u1.getUsername().compareTo(u2.getUsername());
	}
	
}
