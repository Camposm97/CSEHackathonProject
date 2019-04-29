package campos.models;

import java.util.TreeSet;

import campos.collections.UserAccountNameComparator;
import campos.util.BinarySearch;

@SuppressWarnings("serial")
public class UserAccountBag extends TreeSet<UserAccount> {
	public UserAccountBag() {
		super(new UserAccountNameComparator());
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
	
	
	public boolean contains(String username) {
		if (findByUsername(username) != null)
			return true;
		return false;
	}

	public void display() {
		for (UserAccount u : this)
			System.out.println(u);
		System.out.println();
	}
	
	@Override
	public String toString() {
		String str = "";
		for (UserAccount u : this) {
			str += u + "\n";
		}
		return str;
	}
}
