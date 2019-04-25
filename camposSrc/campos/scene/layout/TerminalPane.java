package campos.scene.layout;

import java.util.TreeSet;

import campos.models.UserAccount;
import javafx.scene.layout.BorderPane;

@Deprecated
public abstract class TerminalPane extends BorderPane {
	protected TreeSet<UserAccount> userBag;
	
	public TerminalPane(TreeSet<UserAccount> userBag) {
		this.userBag = userBag;
	}
	
	public TreeSet<UserAccount> getUserTree() {
		return userBag;
	}
}
