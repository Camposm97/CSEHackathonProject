package campos.util;

import java.util.ArrayList;
import java.util.TreeSet;

import campos.collections.UserAccountNameComparator;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.models.UserAccountBag;

public class UserAccountFactory {
	public static UserAccountBag emitUserAccounts(int n) {
		NameFactory nameFactory = new NameFactory();
		ArrayList<Name> nameList = nameFactory.emitNames(n);
		UserAccountBag bag = new UserAccountBag();
		for (int i = 0; i < nameList.size(); i++) {
			bag.add(new UserAccount(new Student(nameList.get(i), Random.emitMajor())));
		}
		return bag;
	}
}
