package campos.scene.layout;

import java.util.ArrayList;

import campos.util.FXUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
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
		super.setHeaderText("Please select your avatar: (Will be Used to Represent Your Profile Picture");
		this.imageList = FXUtil.loadAvatarImages();
		this.buttonList = loadButtonList();
		this.chosenOne = null;
		super.getDialogPane().setContent(new ScrollPane(buttonList.get(0)));
		super.setResizable(true);
		new AvatarPickerUtil(this);
	}
	
	private ArrayList<Button> loadButtonList() {
		ArrayList<Button> list = new ArrayList<Button>();
		float ratio = (float) 0.5;
		for (int i = 0; i < imageList.size(); i++) {
			Button bt = new Button("#" + i);
			Image img = imageList.get(i);
			ImageView iv = new ImageView(imageList.get(i));
			iv.setFitHeight(img.getHeight() * ratio);
			iv.setFitWidth(img.getWidth() * ratio);
			bt.setGraphic(iv);
//			bt.setContentDisplay(ContentDisplay.CENTER);
			bt.setOnAction(e -> {
				chosenOne = iv.getImage();
				System.out.println("Chosen one is now: " + chosenOne);
			});
			list.add(bt);
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
