package campos.scene.layout;

import java.util.ArrayList;

import campos.util.FXUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * AvatarPicker might be on a window of it's own (best not to be, but time is short), so
 * it will have an array of buttons and the buttons content will each have a picture of an avatar
 * for the user to choose for his/her profile picture.  
 * Displayed when the user decides to sign up or wants to change his/her profile picture.  
 * @author Camposm97
 */
public class AvatarPicker extends Alert {
	private ArrayList<Image> imageList;
	private ArrayList<Button> buttonList;
	private Image chosenOne;
	
	public AvatarPicker() {
		super(AlertType.INFORMATION);
		super.setTitle("Avatar Picker (By Camposm)");
		super.setContentText("Please pick an avatar to represent your profile picture");
		this.imageList = FXUtil.loadAvatarImages();
		this.buttonList = loadButtonList();
		this.chosenOne = null;
		new AvatarPickerUtil(this);
	}
	
	private ArrayList<Button> loadButtonList() {
		ArrayList<Button> list = new ArrayList<Button>();
		for (int i = 0; i < imageList.size(); i++) {
			Button bt = new Button("#" + i);
			ImageView iv = new ImageView(imageList.get(i));
			bt.setGraphic(iv);
			bt.setContentDisplay(ContentDisplay.CENTER);
			bt.setOnAction(e -> {
				
			});
		}
		return list;
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
