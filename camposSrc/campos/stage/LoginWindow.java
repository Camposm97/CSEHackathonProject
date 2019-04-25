package campos.stage;

import campos.scene.layout.LoginPane;
import campos.scene.layout.MyBorderPane;
import campos.util.ImgUtil;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clean Code :)
 * @author Camposm97
 */
public class LoginWindow extends Stage {
	private static final int WIDTH = 380;
	private static final int HEIGHT = 524;
	private MyBorderPane root;
	
	public LoginWindow() {
		root = new MyBorderPane(new LoginPane());
		setScene(new Scene(root));
		setWidth(WIDTH);
		setHeight(HEIGHT);
		setTitle("Login");
		setResizable(false);
		ImgUtil.loadStageIcon(this);
	}
}
