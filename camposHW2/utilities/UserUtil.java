package utilities;

import models.Name;
import models.UserAccount;
import view.LoginPane;

public class UserUtil {
	public static String createUsername(Name name, String id) {
		String username = partLastName(name.getLastName());
		username += name.getFirstName().charAt(0);
		username += id.charAt(id.length() - 1);
		return username;
	}
	
	@Deprecated
	public static String createUsername(String lastName, String firstName, String id) {
		String username = partLastName(lastName);
		username += firstName.charAt(0);
		username += id.charAt(id.length() - 1);
		return username;
	}
	
	public static String partLastName(String lastName) {
		String username;
		if (isFourChar(lastName))
			username = lastName.substring(0, 4);
		else
			username = lastName;
		return username;
	}
	
	public static boolean isFourChar(String lastName) {
		return lastName.length() >= 4;
	}
	
	public static void findValidUser(LoginPane loginPane) {
		String username = loginPane.getTfUser().getText();
		String password = loginPane.getTfPassword().getText();
		UserAccount user = loginPane.getUserAccountBag().findByUsername(username);
		
		if (user != null && password.equals(user.getPassword())) {
			loginPane.getLblStatus().setText("Success! :D");
			loginPane.getLblStatus().setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		} else {
			loginPane.getLblStatus().setText("Failure :(");
			loginPane.getLblStatus().setStyle("-fx-text-fill: red; -fx-font-size: 16;");
		}
	}
}