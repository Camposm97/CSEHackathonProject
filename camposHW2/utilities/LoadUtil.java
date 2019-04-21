package utilities;

import models.FileBuilt;
import models.NameBag;
import models.Student;
import models.UserAccount;
import models.UserAccountBag;

public class LoadUtil {
	/**
	 * UserAccountBag is sorted after all users have been added.
	 * @param n
	 * @return
	 */
	public static UserAccountBag loadUserAccountBagSortedAfter(int n) {
		UserAccountBag userBag = new UserAccountBag(n);
		NameBag nameBag = loadNames(n);
		
		for (int i = 0; i < nameBag.size(); i++) {
			userBag.insert(new UserAccount(new Student(nameBag.get(i))));
		}
		userBag.sortByUsername();
		return userBag;
	}
	
	/**
	 * UserAccountBag is sorted after every time a user is added.
	 * @param n
	 * @return
	 */
	public static UserAccountBag loadUserAccountBagSorted(int n) {
		UserAccountBag userBag = new UserAccountBag(n);
		NameBag nameBag = loadNames(n);
		
		for (int i = 0; i < nameBag.size(); i++) {
			userBag.insert(new UserAccount(new Student(nameBag.get(i))));
			userBag.sortByUsername();
		}
		return userBag;
	}
	
	public static NameBag loadNames(int n) {
		NameBag nameBag = new NameBag(n);
		FileBuilt fdBoys = new FileBuilt("males");
		FileBuilt fdGirls = new FileBuilt("females");
		
		for (int i = 0; i < nameBag.size(); i++)
			if (i > (n / 2.0))
				nameBag.insert(Random.getLastName(), fdGirls.getRandomToken(), "female");
			else
				nameBag.insert(Random.getLastName(), fdBoys.getRandomToken(), "male");
		return nameBag;
	}
}
