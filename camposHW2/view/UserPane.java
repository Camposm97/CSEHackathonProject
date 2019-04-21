package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import models.UserAccountBag;

public abstract class UserPane extends GridPane {
	protected UserAccountBag userBag;
	
	public UserPane(UserAccountBag userBag) {
		this.userBag = userBag;
		loadDefaultProperties();
	}
	
	protected void loadDefaultProperties() {
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
	}
	
	public UserAccountBag getUserAccountBag() {
		return userBag;
	}
	
	protected abstract void loadControls();
	
	protected abstract void displayControls();
}
