package campos.scene.layout;

import campos.models.UserAccountBag;
import javafx.scene.layout.BorderPane;

public abstract class TerminalPane extends BorderPane {
	protected UserAccountBag userBag;
	
	public TerminalPane(UserAccountBag userBag) {
		this.userBag = userBag;
	}
	
	public UserAccountBag getUserBag() {
		return userBag;
	}
}
