package campos.scene.layout;

import java.util.TreeSet;

import campos.event.EventLoader;
import campos.models.UserAccount;
import campos.scene.control.MyLabel;
import campos.util.FXUtil;
import campos.util.ImgUtil;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LoginPane extends TerminalPane {
	private MyLabel lblStatus;
	private TextField tfUser;
	private PasswordField tfPassword;
	private Button btLogin;
	private Hyperlink linkSignUp;
	
	public LoginPane(TreeSet<UserAccount> userTree) {
		super(userTree);
		new LoginPaneUtil(this);
		EventLoader.loadEnterKey(this, btLogin);
	}
	
	public TextField getTfUser() {
		return tfUser;
	}
	
	public PasswordField getTfPassword() {
		return tfPassword;
	}
	
	private class LoginPaneUtil {
		private LoginPane loginPane;
		
		public LoginPaneUtil(LoginPane loginPane) {
			this.loginPane = loginPane;
			lblStatus = new MyLabel("Please enter your credentials.", Color.BLACK, 16);
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
			gridPane.setAlignment(Pos.TOP_CENTER);
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			gridPane.add(lblStatus, 0, 0, 4, 1);
			gridPane.add(new Label("Username:"), 0, 1);
			gridPane.add(new Label("Password:"), 0, 2);
			gridPane.add(tfUser, 1, 1);
			gridPane.add(tfPassword, 1, 2);
			gridPane.add(FXUtil.asVBox(btLogin), 0, 3, 4, 1);
			
			VBox vBox = FXUtil.asVBox(FXUtil.loadLblTitle(), ImgUtil.loadImgViewRatio(ImgUtil.ICON_MAIN, 0.5));
			vBox.setPadding(FXUtil.DEFAULT_INSETS);
			
			StackPane pane = new StackPane(linkSignUp);
			pane.setPadding(FXUtil.DEFAULT_INSETS);
			
			loginPane.setTop(vBox);
			loginPane.setCenter(gridPane);
			loginPane.setBottom(pane);
		}
		
		public Button loadBtLogin() {
			Button bt = new Button("Login");
			bt.setPrefWidth(FXUtil.BT_WIDTH);
			bt.setOnAction(e -> {
				findValidUser();
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
		
		public void findValidUser() {
			String username = loginPane.getTfUser().getText();
			String password = loginPane.getTfPassword().getText();
			
			UserAccount user = null;
			
			if (!username.isEmpty() || username.contains("\\")) {
				user = loginPane.getUserTree().findByUsername(username);
			} 
			
			if (user != null && password.equals(user.getPassword())) {
				loginPane.lblStatus.setText("Success! :D");
				loginPane.lblStatus.setTextFill(Color.GREEN);
			} else {
				loginPane.lblStatus.setText("Failure :(");
				loginPane.lblStatus.setTextFill(Color.RED);
			}
		}
	}
}
