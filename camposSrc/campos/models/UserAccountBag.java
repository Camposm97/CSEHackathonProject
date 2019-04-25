package campos.models;

import java.util.TreeSet;

import campos.collections.UserNameComparator;
import campos.util.BinarySearch;

@SuppressWarnings("serial")
public class UserAccountBag extends TreeSet<UserAccount> {
	public UserAccountBag() {
		super(new UserNameComparator());
	}
	
	public UserAccount findByUsername(String username) {
		UserAccount[] arr = new UserAccount[this.size()];
		arr = this.toArray(arr);
		int index = BinarySearch.binarySearch(arr, username, 0, arr.length);
		if (index != -1) {
			return arr[index];
		}
		return null;
	}

	public void display() {
		for (UserAccount u : this)
			System.out.println(u);
		System.out.println();
	}
}
