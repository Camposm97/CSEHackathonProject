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
	
	public UserAccountBag loadUserAccountBag(int n) {
		UserAccountBag userBag = new UserAccountBag(n);
		ArrayList<Name> nameList = nameFactory.emitNames(n);
		
		for (int i = 0; i < nameList.size(); i++) {
			userBag.add(new UserAccount(new Student(nameList.get(i))));
			userBag.sortByUsername();
		}
		userBag.display();
		return userBag;
	}
}
