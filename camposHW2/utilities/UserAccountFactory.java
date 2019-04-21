package utilities;

import models.NameBag;
import models.Student;
import models.UserAccount;
import models.UserAccountBag;

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
		NameBag nameBag = emitNames(n);
		
		for (int i = 0; i < nameBag.size(); i++) {
			userBag.insert(new UserAccount(new Student(nameBag.get(i))));
			userBag.sortByUsername();
		}
		return userBag;
	}
	
	public NameBag emitNames(int n) {
		NameBag nameBag = new NameBag(n);
		
		for (int i = 0; i < nameBag.size(); i++)
			if (i > (n / 2.0))
				nameBag.insert(nameFactory.emitLastName(), nameFactory.emitGirlName(), "female");
			else
				nameBag.insert(nameFactory.emitLastName(), nameFactory.emitBoyName(), "male");
		return nameBag;
	}
}
