package scene.control;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import model.User;

public class MyMenuBar extends MenuBar {
	private Menu menuHome, menuMail, menuProfile, menuFriends, menuMyAccount, menuSignOut;
	
	public MyMenuBar(User user) {
		menuHome = new Menu("Home");
		menuMail = new Menu("Mail");
		menuProfile = new Menu("Profile");
		menuFriends = new Menu("Friends");
		menuMyAccount = new Menu("MyAccount");
		menuSignOut = new Menu("Sign Out");
	}
}
