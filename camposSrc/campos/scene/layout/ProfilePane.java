package campos.scene.layout;

import campos.models.UserAccount;
import campos.scene.control.MyLabel;
import campos.util.FXUtil;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProfilePane extends GridPane {
	private static final int FONT_SIZE = 20;
	private Button btSignOut, btPostFeed;
	private ImageView iv;
	private MyLabel lblUsername, lblMajor, lblName, lblGender;
	
	private UserAccount user;
	
	public ProfilePane(UserAccount user) {
		this.user = user;
		initControls();
	}
	
	private void initControls() {
		btSignOut = new Button("Sign Out");
		btSignOut.setOnAction(e -> {
			Stage stage = (Stage) this.getScene().getWindow();
			stage.close();
			stage = new Stage();
		});
		btPostFeed = new Button("Go to Post Feed");
		iv = new ImageView(user.getImage());
		lblUsername = new MyLabel(user.getUsername(), FONT_SIZE);
		lblName = new MyLabel("Name: " + user.getStudent().getName(), FONT_SIZE);
		lblGender = new MyLabel("Gender: " + user.getStudent().getName().getGender(), FONT_SIZE);
		lblMajor = new MyLabel("Major: " + user.getStudent().getMajor(), FONT_SIZE);
		displayControls();
	}
	
	private void displayControls() {
		this.addRow(0, btSignOut, btPostFeed);
		this.addRow(1, lblUsername);
		this.addRow(2, iv);
		this.addRow(3, lblName);
		this.addRow(4, lblGender);
		this.addRow(5, lblMajor);
		
		this.setAlignment(Pos.TOP_LEFT);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(FXUtil.DEFAULT_INSETS);
	}
}
