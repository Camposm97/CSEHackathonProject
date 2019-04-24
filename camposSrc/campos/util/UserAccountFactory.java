package campos.util;

import java.util.ArrayList;

import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.models.UserAccountBag;

public class UserAccountFactory {
	public static UserAccountBag loadUserAccountBag(int n) {
		NameFactory nameFactory = new NameFactory();
		UserAccountBag userBag = new UserAccountBag(n);
		ArrayList<Name> nameList = nameFactory.emitNames(n);
		
		for (int i = 0; i < nameList.size(); i++) {
			userBag.add(new UserAccount(new Student(nameList.get(i), Random.emitMajor())));
			userBag.sortByUsername();
		}
		return userBag;
	}
}
