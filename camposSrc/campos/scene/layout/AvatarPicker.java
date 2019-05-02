package campos.scene.layout;

import java.util.ArrayList;

import campos.util.FXUtil;
import campos.util.ImgUtil;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * AvatarPicker might be on a window of it's own (best not to be, but time is short), so
 * it will have an array of buttons and the buttons content will each have a picture of an avatar
 * for the user to choose for his/her profile picture.  
 * Displayed when the user decides to sign up or wants to change his/her profile picture.  
 * @author Camposm97
 */
public class AvatarPicker extends Alert {
	private static final int COL_SIZE = 3;
	private ArrayList<Image> imageList;
	private GridPane buttonGridPane;
	private Image chosenOne;
	
	public AvatarPicker() {
		super(AlertType.INFORMATION);
		super.setTitle("Avatar Picker (By Camposm)");
		super.setHeaderText("Please select your Avatar: (Will be Used to Represent Your Profile Picture");
		this.imageList = FXUtil.loadAvatarImages();
		this.buttonGridPane = loadButtonGridPane();
		this.chosenOne = ImgUtil.loadImg("resources/images/avatars/default.png");
		super.getDialogPane().setContent(buttonGridPane);
		super.setResizable(false);
	}
	
	public Image getChosenOne() {
		return chosenOne;
	}
	
	private GridPane loadButtonGridPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		float ratio = (float) 0.5;
		int col = 0, row = 0;
		for (int i = 0; i < imageList.size(); i++) {
			Button bt = new Button("#" + i);
			Image img = imageList.get(i);
			ImageView iv = new ImageView(imageList.get(i));
			iv.setFitHeight(img.getHeight() * ratio);
			iv.setFitWidth(img.getWidth() * ratio);
			bt.setGraphic(iv);
			bt.setContentDisplay(ContentDisplay.BOTTOM);
			bt.setOnAction(e -> {
				chosenOne = iv.getImage();
				System.out.println("Chosen one is now: " + chosenOne);
			});
			gridPane.add(bt, col, row);
			col++;
			if (col > (COL_SIZE - 1)) {
				col = 0;
				row++;
			}
		}
		return gridPane;
	}
}
