package campos.util;

import java.util.ArrayList;
import java.util.TreeSet;

import campos.collections.UserAccountComparator;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.models.UserAccountBag;

public class UserAccountFactory {
	public static void main(String[] args) {
		TreeSet<UserAccount> set = emitUserAccountTree(100);
		System.out.println(set.size());
	}
	
	public static TreeSet<UserAccount> emitUserAccountTree(int n) {
		NameFactory nameFactory = new NameFactory();
		ArrayList<Name> nameList = nameFactory.emitNames(n);
		TreeSet<UserAccount> userMap = new TreeSet<>(new UserAccountComparator());
		
		for (int i = 0; i < nameList.size(); i++) {
			userMap.add(new UserAccount(new Student(nameList.get(i), Random.emitMajor())));
		}
		
		return userMap;
	}
	
	@Deprecated
	public static UserAccountBag emitUserAccounts(int n) {
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
