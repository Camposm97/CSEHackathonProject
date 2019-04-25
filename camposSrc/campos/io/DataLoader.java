package campos.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.TreeSet;

import campos.models.UserAccount;
import campos.models.UserAccountBag;

public class DataLoader implements DataConstants {
	public static void main(String[] args) {
		UserAccountBag bag = loadUserBag();
		bag.display();
		UserAccount user = new UserAccount(null, "CurtK2", null);
//		UserAccount user = bag.findByUsername("CurtK2");
		System.out.println(bag.contains(user));
	}
	
	public static UserAccountBag loadUserBag() {
		UserAccountBag bag = null;
		File file = new File(USER_BAG_SRC);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			bag = (UserAccountBag) ois.readObject();
			ois.close();
			System.out.println("Successfully read from " + file.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}
}
