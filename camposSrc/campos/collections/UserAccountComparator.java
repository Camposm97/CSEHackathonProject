package campos.collections;

import java.io.Serializable;
import java.util.Comparator;

import campos.models.UserAccount;

@SuppressWarnings("serial")
public class UserAccountComparator implements Comparator<UserAccount>, Serializable {

	@Override
	public int compare(UserAccount u1, UserAccount u2) {
		return u1.getUsername().compareTo(u2.getUsername());
	}
	
}
