package campos.scene.layout;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

/**
 * AvatarPicker might be on a window of it's own (best not to be, but time is short), so
 * it will have an array of buttons and the buttons content will each have a picture of an avatar
 * for the user to choose for his/her profile picture.  
 * Displayed when the user decides to sign up or wants to change his/her profile picture.  
 * @author Camposm97
 */
public class AvatarPicker extends Alert {
	private ArrayList<Image> imageList;
	private Image chosenOne;
	
	public AvatarPicker() {
		super(AlertType.INFORMATION);
		super.setTitle("Avatar Picker (By Camposm)");
		super.setContentText("Please pick an avatar to represent your profile picture");
		new AvatarPickerUtil(this);
	}
	
	private class AvatarPickerUtil {
		public AvatarPicker avaPicker;
		
		public AvatarPickerUtil(AvatarPicker avaPicker) {
			this.avaPicker = avaPicker;
		}
		
		private void loadControls() {
			
		}
	}
}
