package campos.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import campos.models.UserAccountBag;

public class DataLoader implements DataConstants {
	public static void main(String[] args) {
		UserAccountBag bag = loadUserBag();
		bag.display();
//		UserAccount user = new UserAccount(null, "CurtK2", null);
//		UserAccount user = bag.findByUsername("CurtK2");
		System.out.println(bag.contains("GuthK3"));
	}
	
	public static int loadIdNumber() {
		Integer idNumber = (Integer) loadObject(ID_SRC);
		return idNumber;
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
	
	public static Object loadObject(String src) {
		Object o = null;
		File file = new File(src);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			o = ois.readObject();
			ois.close();
			System.out.println("Successfully read from " + file.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}
