package doerz.view;

import campos.models.Gender;
import campos.models.Major;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.scene.layout.AvatarPicker;
import campos.util.ImgUtil;
import doerz.view.layout.ProfilePane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.Dummy;

/*
 * Quick way to edit a userAccounts information
 */

public class UserWindow {
	private Button okBtn, avatarBtn;
	private ImageView avatar;
	private TextField firstFld, lastFld, userFld;
	private	Stage userStage;
	
	public UserWindow(UserAccount user) {
		VBox box = new VBox();
		box.setPadding(new Insets(20));
		box.setSpacing(5);
		
		userStage = new Stage();
		userStage.setResizable(false);
		
		Scene userScene = new Scene(box, 210, 360);
			firstFld = new TextField(user.getStudent().getName().getFirstName());
			lastFld = new TextField(user.getStudent().getName().getLastName());
			userFld = new TextField(user.getUsername());
		
			okBtn = new Button("Okay");
			okBtn.setAlignment(Pos.CENTER);
			
			avatar = ImgUtil.loadImgVR(ImgUtil.DEFAULT_PROFILE, 0.4);
			avatarBtn = new Button();
			avatarBtn.setGraphic(avatar);
			avatarBtn.setAlignment(Pos.CENTER);
			
		Label avatarLbl, firstLbl, lastLbl, userLbl;
			avatarLbl = new Label("Avatar:");
			firstLbl = new Label("First Name:");
			lastLbl = new Label("Last Name:");
			userLbl = new Label("Username:");
		box.getChildren().addAll(avatarLbl, avatarBtn, firstLbl, firstFld, lastLbl, lastFld, userLbl, userFld, okBtn);
		
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
			ProfilePane.refreshNodes();
			userStage.close();
		});
		
		avatarBtn.setOnAction(e -> {
			AvatarPicker picker = new AvatarPicker();
			picker.showAndWait();
		});
	}
}
