package doerz.view;

import campos.models.Major;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.util.Gender;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.Dummy;

/*
 * Temporary way to create a user account to post with. This is used for development purposes only.
 */

public class UserWindow {
	private Button okBtn;
	private TextField firstFld, lastFld, userFld;
	private	Stage userStage;
	
	public UserWindow(UserAccount user) {
		VBox box = new VBox();
		box.setPadding(new Insets(20));
		
		userStage = new Stage();
		Scene userScene = new Scene(box, 200, 300);
			firstFld = new TextField();
			lastFld = new TextField();
			userFld = new TextField();
		
			okBtn = new Button("Okay");
			okBtn.setAlignment(Pos.CENTER);
			
		Label firstLbl, lastLbl, userLbl;
			firstLbl = new Label("First Name:");
			lastLbl = new Label("Last Name:");
			userLbl = new Label("Username:");
		box.getChildren().addAll(firstLbl, firstFld, lastLbl, lastFld, userLbl, userFld, okBtn);
		
		callBacks(user);
		
		userStage.setScene(userScene);
		userStage.show();
	}

	private void callBacks(UserAccount userAcc) {
		okBtn.setOnAction(e -> {
			String first = firstFld.getText();
			String last = lastFld.getText();
			String user = userFld.getText();
			
			Name name = new Name(first, last, Gender.Male);
			System.out.println(name);
			Student student = new Student(name, Major.CSE);
			System.out.println(student);
			
			userAcc.setStudent(student);
			userAcc.setUsername(user);
			userAcc.setPassword(Dummy.getRandomPass());
			
//			userAcc = new UserAccount(student, user, Dummy.getRandomPass());
			
			userStage.close();
		});
	}
}
