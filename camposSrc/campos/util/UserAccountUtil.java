package campos.util;

import campos.models.Name;
import campos.models.UserAccount;
import campos.scene.layout.LoginPane;

public class UserAccountUtil {
	public static String createUsername(Name name, String id) {
		String username = parseLastName(name.getLastName());
		username += name.getFirstName().charAt(0);
		username += id.charAt(id.length() - 1);
		return username;
	}
	
	public static String parseLastName(String lastName) {
		String username;
		if (isLengthFour(lastName))
			username = lastName.substring(0, 4);
		else
			username = lastName;
		return username;
	}
	
	public static boolean isLengthFour(String lastName) {
		return lastName.length() >= 4;
	}
}
