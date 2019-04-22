package campos.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import campos.models.UserAccountBag;

public class DataOperator {
	private static final String USER_BAG_SRC = "resources/data/userBag.dat";
	
	public static UserAccountBag loadUsers() {
		UserAccountBag userBag = null;
		File file = new File(USER_BAG_SRC);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			userBag = (UserAccountBag) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBag;
	}
	
	public static void saveUsers(UserAccountBag userBag) {
		File file = new File(USER_BAG_SRC);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(userBag);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
