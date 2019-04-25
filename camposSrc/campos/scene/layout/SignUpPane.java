package campos.scene.layout;

import campos.event.EventLoader;
import campos.models.Major;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.models.UserAccountBag;
import campos.util.FXUtil;
import campos.util.Gender;
import campos.util.PasswordUtil;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

public class SignUpPane extends TerminalPane {
	private TextField tfFirstName, tfLastName, tfUsername;
	private ComboBox<Gender> cbGender;
	private ComboBox<Major> cbMajor;
	private PasswordField tfPass, tfPassReType;
	private Button btSignUp, btCancel;

	public SignUpPane(UserAccountBag userBag) {
		super(userBag);
		new SignUpPaneUtil(this);
		EventLoader.loadEnterKey(this, btSignUp);
	}
	
	private class SignUpPaneUtil {
		private SignUpPane signUpPane;
		
		public SignUpPaneUtil(SignUpPane signUpPane) {
			this.signUpPane = signUpPane;
			loadControls();
			displayControls();
		}
		
		public void loadControls() {
			btSignUp = loadBtSignUp();
			btCancel = loadBtCancel();
			tfFirstName = new TextField();
			tfLastName = new TextField();
			tfUsername = loadTfUsername();
			tfPass = loadTfPass();
			tfPassReType = loadTfPassReType();
			cbGender = FXUtil.loadCbGender();
			cbMajor = FXUtil.loadCbMajor();
		}
		
		public void displayControls() {
			GridPane gridPane = new GridPane();
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			gridPane.add(new Label("First Name:"), 0, 0);
			gridPane.add(new Label("Last Name:"), 0, 1);
			gridPane.add(new Label("Gender:"), 0, 2);
			gridPane.add(new Label("Major:"), 0, 3);
			gridPane.add(new Label("Username:"), 0, 4);
			gridPane.add(new Label("Password"), 0, 5);
			gridPane.add(new Label("Re-Type Password:"), 0, 6);
			gridPane.add(tfFirstName, 1, 0);
			gridPane.add(tfLastName, 1, 1);
			gridPane.add(cbGender, 1, 2);
			gridPane.add(cbMajor, 1, 3);
			gridPane.add(tfUsername, 1, 4);
			gridPane.add(tfPass, 1, 5);
			gridPane.add(tfPassReType, 1, 6);
			gridPane.add(FXUtil.asHBox(btSignUp, btCancel), 0, 7, 3, 1);
			signUpPane.setCenter(gridPane);
		}
		
		private TextField loadTfUsername() {
			TextField tf = new TextField();
			Tooltip tip = new Tooltip("Valid username!");
			tip.setStyle("-fx-hide-delay: 10ms");
			tf.setTooltip(tip);
			
			tf.textProperty().addListener((observable, oldValue, newValue) -> {
				if (newValue.contains("\\"))
					return;
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
			bt.setPrefWidth(FXUtil.BT_WIDTH);
			bt.setOnAction(e -> {
				if (fieldsAreValid())
					addUserToBag();
			});
			return bt;
		}

		private Button loadBtCancel() {
			Button bt = new Button("Cancel");
			bt.setPrefWidth(FXUtil.BT_WIDTH);
			bt.setOnAction(e -> {
				FXUtil.toLoginPane(signUpPane);
			});
			return bt;
		}
		
		public boolean fieldsAreValid() {
			return !signUpPane.tfFirstName.getText().isEmpty() && 
					!signUpPane.tfLastName.getText().isEmpty() && 
					!signUpPane.tfUsername.getText().isEmpty();
		}
		
		public void addUserToBag() {
			String lastName = signUpPane.tfLastName.getText();
			String firstName = signUpPane.tfFirstName.getText();
			
			String username = signUpPane.tfUsername.getText();
			String password = signUpPane.tfPass.getText();
			
			Student student = new Student(new Name(lastName, firstName, cbGender.getValue()), cbMajor.getValue());
			signUpPane.getUserTree().add(new UserAccount(student, username, password));
			signUpPane.getUserTree().sortByUsername();
			System.out.println();
			signUpPane.getUserTree().display();
			FXUtil.toLoginPane(signUpPane);
		}
	}
}
