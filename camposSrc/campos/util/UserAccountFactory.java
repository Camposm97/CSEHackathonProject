package campos.util;

import java.util.ArrayList;
import java.util.TreeSet;

import campos.collections.UserAccountComparator;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;

public class UserAccountFactory {
	public static TreeSet<UserAccount> emitUserAccounts(int n) {
		NameFactory nameFactory = new NameFactory();
		ArrayList<Name> nameList = nameFactory.emitNames(n);
		TreeSet<UserAccount> userMap = new TreeSet<>(new UserAccountComparator());
		for (int i = 0; i < nameList.size(); i++) {
			userMap.add(new UserAccount(new Student(nameList.get(i), Random.emitMajor())));
		}
		return userMap;
	}
}
