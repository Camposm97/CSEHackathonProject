package campos.collections;

import java.io.Serializable;
import java.util.Comparator;

import campos.models.UserAccount;

@SuppressWarnings("serial")
public class UserAccountPasswordComparator implements Comparator<UserAccount>, Serializable {

	@Override
	public int compare(UserAccount o1, UserAccount o2) {
		return o1.getPassword().compareTo(o2.getPassword());
	}	
}
