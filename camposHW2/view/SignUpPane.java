package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import models.UserAccount;
import models.UserAccountBag;
import utilities.EventLoader;
import utilities.FXLoader;
import utilities.PasswordUtil;
import utilities.SignUpUtil;

public class SignUpPane extends UserPane {
	private TextField tfFirstName, tfLastName, tfGender, tfGpa, tfUsername;
	private PasswordField tfPass, tfPassReType;
	private Button btSignUp, btCancel;

	public SignUpPane(UserAccountBag userBag) {
		super(userBag);
		loadControls();
		displayControls();
		EventLoader.loadEnterKey(this, btSignUp);
	}
	
	@Override
	protected void loadControls() {
		btSignUp = loadBtSignUp();
		btCancel = loadBtCancel();
		tfFirstName = new TextField();
		tfLastName = new TextField();
		tfGender = new TextField();
		tfGpa = loadTfGpa();
		tfUsername = loadTfUsername();
		tfPass = loadTfPass();
		tfPassReType = loadTfPassReType();
	}

	@Override
	protected void displayControls() {
		add(new Label("First Name:"), 0, 0);
		add(new Label("Last Name:"), 0, 1);
		add(new Label("Gender:"), 0, 2);
		add(new Label("GPA:"), 0, 3);
		add(new Label("Username:"), 0, 4);
		add(new Label("Password"), 0, 5);
		add(new Label("Re-Type Password:"), 0, 6);
		add(tfFirstName, 1, 0);
		add(tfLastName, 1, 1);
		add(tfGender, 1, 2);
		add(tfGpa, 1, 3);
		add(tfUsername, 1, 4);
		add(tfPass, 1, 5);
		add(tfPassReType, 1, 6);
		add(FXLoader.loadNodesAsHBox(btSignUp, btCancel), 0, 7, 3, 1);
	}
	
	private TextField loadTfGpa() {
		TextField tf = new TextField();
		tf.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				double gpa = Double.parseDouble(newValue);
				
				if (gpa >= 0.0 && gpa <= 4.0) {
					tf.setStyle("");
					btSignUp.setDisable(false);
				} else {
					tf.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
					btSignUp.setDisable(true);
				}
			} catch (Exception e) {
				tf.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
				btSignUp.setDisable(true);
			}
		});
		return tf;
	}
	
	private TextField loadTfUsername() {
		TextField tf = new TextField();
		Tooltip tip = new Tooltip("Valid username!");
		tip.setStyle("-fx-hide-delay: 10ms");
		tf.setTooltip(tip);
		
		tf.textProperty().addListener((observable, oldValue, newValue) -> {
			UserAccount user = userBag.findByUsername(newValue);
			if (user != null) {
				tfUsername.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
				tip.setText("Sorry, that username is already taken :(");
				btSignUp.setDisable(true);
			} else {
				tfUsername.setStyle("");
				tip.setText("Valid username!");
				btSignUp.setDisable(false);
			}
		});
		return tf;
	}
	
	private PasswordField loadTfPass() {
		PasswordField tf = new PasswordField();
		Tooltip tip = new Tooltip("Valid Password!");
		tf.setTooltip(tip);
		tf.textProperty().addListener((observable, oldValue, newValue) -> {
			if (PasswordUtil.isValid(newValue)) {
				tf.setStyle("");
				tfPass.setStyle("");
				btSignUp.setDisable(false);
				tip.setText("Valid Password!");
			} else {
				tf.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
				tfPass.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
				btSignUp.setDisable(true);
				tip.setText("Invalid Password!\n" 
						+ "Your password must be 8 characters long.\n"
						+ "Have at least one uppercase and lowercase letter.\n"
						+ "Have one of the following characters:  !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
			}
		});
		return tf;
	}
	
	private PasswordField loadTfPassReType() {
		PasswordField tf = new PasswordField();
		tf.textProperty().addListener((observable, oldValue, newValue) -> {
			String password = tfPass.getText();
			if (newValue.equals(password)) {
				tf.setStyle("");
				tfPass.setStyle("");
				btSignUp.setDisable(false);
			} else {
				tf.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
				tfPass.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
				btSignUp.setDisable(true);
			}
		});
		return tf;
	}

	private Button loadBtSignUp() {
		Button bt = new Button("Sign Up");
		bt.setPrefWidth(FXLoader.BT_WIDTH);
		bt.setOnAction(e -> {
			if (SignUpUtil.fieldsAreValid(this))
				SignUpUtil.addUserToBag(this);
		});
		return bt;
	}

	private Button loadBtCancel() {
		Button bt = new Button("Cancel");
		bt.setPrefWidth(FXLoader.BT_WIDTH);
		bt.setOnAction(e -> {
			FXLoader.switchToLoginPane(this);
		});
		return bt;
	}

	public TextField getTfFirstName() {
		return tfFirstName;
	}

	public TextField getTfLastName() {
		return tfLastName;
	}

	public TextField getTfGender() {
		return tfGender;
	}

	public TextField getTfGpa() {
		return tfGpa;
	}

	public TextField getTfUsername() {
		return tfUsername;
	}

	public PasswordField getTfPass() {
		return tfPass;
	}

	public PasswordField getTfPassConfirmed() {
		return tfPassReType;
	}
}
