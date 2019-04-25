package campos.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.TreeSet;

import campos.models.UserAccount;

public class DataLoader implements DataConstants{
	public static void main(String[] args) {
		TreeSet<UserAccount> userTree = loadUsers();
		for (UserAccount u : userTree)
			System.out.println(u);
	}
	
	@SuppressWarnings("unchecked")
	public static TreeSet<UserAccount> loadUsers() {
		TreeSet<UserAccount> userTree = null;
		File file = new File(USER_BAG_SRC);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			userTree = (TreeSet<UserAccount>) ois.readObject();
			ois.close();
			System.out.println("Successfully read from " + file.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userTree;
	}
}
