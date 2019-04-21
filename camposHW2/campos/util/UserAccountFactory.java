package campos.util;

import java.util.ArrayList;

import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.models.UserAccountBag;

public class UserAccountFactory {
	private NameFactory nameFactory;
	
	public UserAccountFactory() {
		this.nameFactory = new NameFactory();
	}
	
	/**
	 * UserAccountBag is sorted after every time a user is added.
	 * @param n
	 * @return
	 */
	public UserAccountBag loadUserAccountBagSorted(int n) {
		UserAccountBag userBag = new UserAccountBag(n);
		ArrayList<Name> nameList = nameFactory.emitNames(n);
		
		for (int i = 0; i < nameList.size(); i++) {
			userBag.insert(new UserAccount(new Student(nameList.get(i))));
			userBag.sortByUsername();
		}
		return userBag;
	}
}
