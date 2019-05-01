package campos.scene.layout;

import java.util.ArrayList;

import campos.util.FXUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * AvatarPicker might be on a window of it's own (best not to be, but time is short), so
 * it will have an array of buttons and the buttons content will each have a picture of an avatar
 * for the user to choose for his/her profile picture.  
 * Displayed when the user decides to sign up or wants to change his/her profile picture.  
 * @author Camposm97
 */
public class AvatarPicker extends Alert {
	private ArrayList<Image> imageList;
	private GridPane buttonGridPane;
	private Image chosenOne;
	
	public AvatarPicker() {
		super(AlertType.INFORMATION);
		super.setTitle("Avatar Picker (By Camposm)");
		super.setHeaderText("Please select your avatar: (Will be Used to Represent Your Profile Picture");
		this.imageList = FXUtil.loadAvatarImages();
		this.buttonGridPane = loadButtonGridPane();
		this.chosenOne = null;
		super.getDialogPane().setExpandableContent(new ScrollPane(buttonGridPane));
		super.setResizable(false);
	}
	
	private GridPane loadButtonGridPane() {
//		ArrayList<Button> list = new ArrayList<Button>();
//		VBox vBox = new VBox(10);
		GridPane gridPane = new GridPane();
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
//			list.add(bt);
//			vBox.getChildren().add(bt);
			gridPane.add(bt, 0, i);
		}
		return gridPane;
	}
}
