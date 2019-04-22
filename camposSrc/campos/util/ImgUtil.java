package campos.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImgUtil {
	public static final String ICON_MAIN = "resources/images/icons/puzzle.png";
	
	public static void loadStageIcon(Stage stage) {
		stage.getIcons().add(loadImg(ICON_MAIN));
	}
	
	public static Image loadImg(String url) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(url));
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		return new Image(fis);
	}
	
	public static ImageView loadImgView(String url) {
		return new ImageView(loadImg(url));
	}
	
	public static ImageView loadImgViewRatio(String url, double ratio) {
		ImageView iv = new ImageView(loadImg(url));
		iv.setFitWidth(iv.getImage().getWidth() * ratio);
		iv.setFitHeight(iv.getImage().getHeight() * ratio);
		return iv;
	}
}
