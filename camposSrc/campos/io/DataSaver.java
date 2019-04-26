package campos.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import campos.models.UserAccountBag;
import campos.util.UserAccountFactory;

public class DataSaver implements DataConstants {
	public static void main(String[] args) {
		UserAccountBag bag = UserAccountFactory.emitUserAccounts(10);
		saveUserBag(bag);
	}
	
	public static void saveUserBag(UserAccountBag userBag) {
		saveObject(userBag, USER_BAG_SRC);
	}
	
	public static void saveObject(Object o, String trgt) {
		File file = new File(trgt);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(o);
			System.out.println("Successfully saved to " + file.getPath());
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
