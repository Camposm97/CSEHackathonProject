package campos.scene.layout;

import campos.models.UserAccountBag;
import javafx.scene.layout.BorderPane;

public abstract class UserPane extends BorderPane {
	protected UserAccountBag userBag;
	
	public UserPane(UserAccountBag userBag) {
		this.userBag = userBag;
	}
	
	public UserAccountBag getUserBag() {
		return userBag;
	}
}
