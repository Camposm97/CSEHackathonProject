package campos.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import campos.models.UserAccountBag;
import campos.util.UserAccountFactory;

public class DataSaver {
	public static void main(String[] args) {
		UserAccountBag bag = UserAccountFactory.loadUserAccountBag(50);
		saveUsers(bag);
	}
	
	public static void saveUsers(UserAccountBag userBag) {
		File file = new File(DataUtil.USER_BAG_SRC);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(userBag);
			oos.close();
			System.out.println("Successfully saved to " + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
