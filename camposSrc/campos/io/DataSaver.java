package campos.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import java.util.TreeSet;

import campos.models.UserAccount;
import campos.util.UserAccountFactory;

public class DataSaver implements DataConstants {
	public static void main(String[] args) {
		TreeMap<String, UserAccount> userMap = new TreeMap<>();
		
		TreeSet<UserAccount> userTree = UserAccountFactory.emitUserAccounts(10);
		saveObject(userTree, USER_BAG_SRC);
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
