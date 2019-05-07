package campos.scene.layout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private ArrayList<File> fileList;
	private GridPane buttonGridPane;
//	private Image chosenOne;
	private File chosenOne;
	
	public AvatarPicker() {
		super(AlertType.INFORMATION);
		super.setTitle("Avatar Picker (By Camposm)");
		super.setHeaderText("Please select your Avatar: (Will be Used to Represent Your Profile Picture");
		this.fileList = FXUtil.loadAvatarFiles();
		this.buttonGridPane = loadButtonGridPane();
//		this.chosenOne = ImgUtil.loadImg("resources/images/avatars/default.png");
		this.chosenOne = new File(ImgUtil.DEFAULT_PROFILE);
		super.getDialogPane().setContent(buttonGridPane);
		super.setResizable(false);
	}
	
	public File getChosenOne() {
		return chosenOne;
	}
	
	private GridPane loadButtonGridPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		int col = 0, row = 0;
		
		for (int i = 0; i < fileList.size(); i++) {
			Button bt = loadBt(i);
			gridPane.add(bt, col, row);
			col++;
			if (col > (COL_SIZE - 1)) {
				col = 0;
				row++;
			}
		}
		return gridPane;
	}
	
	private Button loadBt(int i) {
		int x = i;
		float ratio = (float) 0.5;
		Button bt = new Button("#" + i);
		try {
			Image img = new Image(new FileInputStream(fileList.get(i)));
			ImageView iv = new ImageView(img);
			iv.setFitHeight(img.getHeight() * ratio);
			iv.setFitWidth(img.getWidth() * ratio);
			bt.setGraphic(iv);
			bt.setOnAction(e -> {
				chosenOne = fileList.get(x);
				System.out.println("Chosen one is now: " + chosenOne);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bt;
	}
}
