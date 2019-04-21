package campos.scene.layout;

import campos.models.UserAccountBag;
import campos.util.EventLoader;
import campos.util.FXUtil;
import campos.util.UserUtil;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class LoginPane extends UserPane {
	private Label lblStatus;
	private TextField tfUser;
	private PasswordField tfPassword;
	private Button btLogin;
	private Hyperlink linkSignUp;
	
	public LoginPane(UserAccountBag userBag) {
		super(userBag);
		new LoginPaneUtil(this);
		EventLoader.loadEnterKey(this, btLogin);
	}
	
	public TextField getTfUser() {
		return tfUser;
	}
	
	public PasswordField getTfPassword() {
		return tfPassword;
	}
	
	public Label getLblStatus() {
		return lblStatus;
	}
	
	private class LoginPaneUtil {
		private LoginPane loginPane;
		
		public LoginPaneUtil(LoginPane loginPane) {
			this.loginPane = loginPane;
			lblStatus = new Label("Please enter your credentials.");
			lblStatus.setStyle("-fx-font-size: 16;");
			tfUser = new TextField();
			tfUser.setPromptText("Username");
			tfPassword = new PasswordField();
			tfPassword.setPromptText("Password");
			btLogin = loadBtLogin();
			linkSignUp = loadHyperlinkSignUp();
			displayControls();
		}
		
		public void displayControls() {
			GridPane gridPane = new GridPane();
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			gridPane.add(lblStatus, 0, 0, 4, 1);
			gridPane.add(new Label("Username:"), 0, 1);
			gridPane.add(new Label("Password:"), 0, 2);
			gridPane.add(tfUser, 1, 1);
			gridPane.add(tfPassword, 1, 2);
			gridPane.add(FXUtil.asVBox(btLogin), 0, 3, 4, 1);
			loginPane.setCenter(gridPane);
			loginPane.setBottom(FXUtil.asVBox(linkSignUp));
		}
		
		public Button loadBtLogin() {
			Button bt = new Button("Login");
			bt.setPrefWidth(FXUtil.BT_WIDTH);
			bt.setOnAction(e -> {
				UserUtil.findValidUser(loginPane);
			});
			return bt;
		}
		
		public Hyperlink loadHyperlinkSignUp() {
			Hyperlink hyperLink = new Hyperlink("Don't have an account? Click here to Sign Up!");
			hyperLink.setOnAction(e -> {
				FXUtil.toSignUpPane(loginPane);
			});
			return hyperLink;
		}
	}
}
