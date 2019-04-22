package campos.util;

import campos.models.Name;
import campos.models.UserAccount;
import campos.scene.layout.LoginPane;

public class UserUtil {
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
	
	public static void findValidUser(LoginPane loginPane) {
		String username = loginPane.getTfUser().getText();
		String password = loginPane.getTfPassword().getText();
		
		UserAccount user = null;
		
		if (!username.isEmpty() || username.contains("\\")) {
			user = loginPane.getUserBag().findByUsername(username);
		} 
		
		if (user != null && password.equals(user.getPassword())) {
			loginPane.getLblStatus().setText("Success! :D");
			loginPane.getLblStatus().setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		} else {
			loginPane.getLblStatus().setText("Failure :(");
			loginPane.getLblStatus().setStyle("-fx-text-fill: red; -fx-font-size: 16;");
		}
	}
}
