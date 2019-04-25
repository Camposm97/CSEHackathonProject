package campos.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import campos.models.UserAccountBag;

public class DataLoader implements URLConstants{
	public static void main(String[] args) {
		UserAccountBag bag = loadUsers();
	}
	
	public static UserAccountBag loadUsers() {
		UserAccountBag userBag = null;
		File file = new File(USER_BAG_SRC);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			userBag = (UserAccountBag) ois.readObject();
			ois.close();
			System.out.println("Successfully read from " + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBag;
	}
}
