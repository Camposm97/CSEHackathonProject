package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.UserAccountBag;
import utilities.EventLoader;
import utilities.FXLoader;
import utilities.UserUtil;

public class LoginPane extends UserPane {
	private Label lblStatus;
	private TextField tfUser;
	private PasswordField tfPassword;
	private Button btLogin, btSignUp;
	
	public LoginPane(UserAccountBag userBag) {
		super(userBag);
		loadControls();
		displayControls();
		EventLoader.loadEnterKey(this, btLogin);
	}
	
	@Override
	protected void loadControls() {
		lblStatus = new Label("Please enter your credentials.");
		lblStatus.setStyle("-fx-font-size: 16;");
		tfUser = new TextField();
		tfUser.setPromptText("Username");
		tfPassword = new PasswordField();
		tfPassword.setPromptText("Password");
		btLogin = loadBtLogin();
		btSignUp = loadBtSignUp();
	}
	
	@Override
	protected void displayControls() {
		add(lblStatus, 0, 0, 4, 1);
		add(new Label("Username:"), 0, 1);
		add(new Label("Password:"), 0, 2);
		add(tfUser, 1, 1);
		add(tfPassword, 1, 2);
		add(FXLoader.loadNodesAsVBox(btLogin, btSignUp), 0, 3, 4, 1);
	}
	
	private Button loadBtLogin() {
		Button bt = new Button("Login");
		bt.setPrefWidth(FXLoader.BT_WIDTH);
		bt.setOnAction(e -> {
			UserUtil.findValidUser(this);
		});
		return bt;
	}
	
	private Button loadBtSignUp() {
		Button bt = new Button("Sign Up");
		bt.setPrefWidth(FXLoader.BT_WIDTH);
		bt.setOnAction(e -> {
			FXLoader.switchToSignUpPane(this);
		});
		return bt;
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
}
