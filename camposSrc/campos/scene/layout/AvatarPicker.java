package campos.scene.layout;

import javafx.scene.layout.StackPane;

/**
 * AvatarPicker might be on a window of it's own (best not to be, but time is short), so
 * it will have an array of buttons and the buttons content will each have a picture of an avatar
 * for the user to choose for his/her profile picture.  
 * Displayed when the user decides to sign up or wants to change his/her profile picture.  
 * @author Camposm97
 */
public class AvatarPicker extends StackPane {
	public AvatarPicker() {
		new AvatarPickerUtil();
	}
	
	private class AvatarPickerUtil {
		
	}
}
