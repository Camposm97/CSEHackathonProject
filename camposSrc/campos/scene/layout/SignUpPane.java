package campos.scene.layout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import campos.event.EventLoader;
import campos.models.Gender;
import campos.models.Major;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.scene.control.ButtonAvatar;
import campos.scene.control.ButtonSignUp;
import campos.util.AlertFactory;
import campos.util.FXUtil;
import campos.util.PasswordUtil;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class SignUpPane extends BorderPane {
	private TextField tfFirstName, tfLastName, tfUsername;
	private ComboBox<Gender> cbGender;
	private ComboBox<Major> cbMajor;
	private PasswordField tfPass, tfPassReType;
	private ButtonSignUp btSignUp;
	private ButtonAvatar btAvatar;
	private Button btCancel;

	public SignUpPane() {
		new SignUpPaneUtil(this);
		EventLoader.loadEnterKey(this, btSignUp);
	}
	
	public boolean fieldsAreValid() {
		return !tfFirstName.getText().isEmpty() && 
				!tfLastName.getText().isEmpty() && 
				!tfUsername.getText().isEmpty() &&
				!tfPass.getText().isEmpty() &&
				!tfPassReType.getText().isEmpty();
	}
	
	public TextField getTfUsername() {
		return tfUsername;
	}
	
	public void setValidSignUp(boolean flag) {
		Tooltip tip = new Tooltip();
		tfUsername.setTooltip(tip);
		if (flag) {
			Platform.runLater(() -> {
				tfUsername.setStyle("");
				AlertFactory.emitInfoAlert("Sign Up", null, "Successfully signed up to Connect!");
			});
		} else {
			tfUsername.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
			tip.setText("Sorry, that username is already taken :(");
		}
	}
	
	public UserAccount getUserAccount() {
		File imageFile = btAvatar.getAvatarPicker().getChosenOne();
		System.out.println(imageFile);
		
		Name name = new Name(tfLastName.getText(), tfFirstName.getText(), cbGender.getValue());
		Student s = new Student(name, cbMajor.getValue());
		UserAccount user = new UserAccount(s, imageFile, tfUsername.getText(), tfPass.getText());
		return user;
	}
	
	/** PRO TIP [2019-May-02 | 8:46 AM EST]
	 * Benefits of Using Inner Classes:
	 * 1. It can access the members from the outer class (instance variables and methods)
	 * 2. Inner classes (Alternative Name: Nested Classes :O) can be used to develop
	 * more readable and maintainable code
	 * 3. (Big OOF) CODE OPTIMIZATION, requires less code to write :)
	 * @author Camposm97
	 */
	private class SignUpPaneUtil {
		private SignUpPane signUpPane;
		
		public SignUpPaneUtil(SignUpPane signUpPane) {
			this.signUpPane = signUpPane;
			loadControls();
			displayControls();
		}
		
		public void loadControls() {
			btSignUp = new ButtonSignUp(signUpPane);
			btCancel = loadBtCancel();
			btAvatar = new ButtonAvatar();
			tfFirstName = new TextField();
			tfLastName = new TextField();
			tfUsername = new TextField();
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
			gridPane.add(FXUtil.asVBox(btAvatar), 0, 0, 2, 1);
			gridPane.addRow(1, new Label("First Name:"), tfFirstName); // Wow OP Function
			gridPane.addRow(2, new Label("Last Name:"), tfLastName); // Since JavaFX 1.0
			gridPane.addRow(3, new Label("Gender:"), cbGender); // Wow look how many
			gridPane.addRow(4, new Label("Major:"), cbMajor); // lines of code I 
			gridPane.addRow(5, new Label("Username:"), tfUsername); // saved :D
			gridPane.addRow(6, new Label("Password:"), tfPass);
			gridPane.addRow(7, new Label("Re-Type Password:"), tfPassReType);
//			gridPane.add(new Label("First Name:"), 0, 0);
//			gridPane.add(new Label("Last Name:"), 0, 1);
//			gridPane.add(new Label("Gender:"), 0, 2);
//			gridPane.add(new Label("Major:"), 0, 3);
//			gridPane.add(new Label("Username:"), 0, 4);
//			gridPane.add(new Label("Password"), 0, 5);
//			gridPane.add(new Label("Re-Type Password:"), 0, 6);
//			gridPane.add(tfFirstName, 1, 0);
//			gridPane.add(tfLastName, 1, 1);
//			gridPane.add(cbGender, 1, 2);
//			gridPane.add(cbMajor, 1, 3);
//			gridPane.add(tfUsername, 1, 4);
//			gridPane.add(tfPass, 1, 5);
//			gridPane.add(tfPassReType, 1, 6);
			gridPane.add(FXUtil.asHBox(btSignUp, btCancel), 0, 8, 3, 1);
			signUpPane.setCenter(gridPane);
		}
				
		private PasswordField loadTfPass() {
			PasswordField tf = new PasswordField();
			Tooltip tip = new Tooltip();
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

		private Button loadBtCancel() {
			Button bt = new Button("Cancel");
			bt.setPrefWidth(FXUtil.BT_WIDTH);
			bt.setOnAction(e -> {
				FXUtil.toLoginPane(signUpPane);
			});
			return bt;
		}
	}
}
