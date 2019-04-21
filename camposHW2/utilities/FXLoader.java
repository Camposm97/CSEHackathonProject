package utilities;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.LoginPane;
import view.SignUpPane;

public class FXLoader {
	public static final double BT_WIDTH = 86;
	public static final double USER_WIDTH = 380;
	public static final double USER_HEIGHT = 500;
	
	public static VBox loadNodesAsVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		
		for (Node e : nodes)
			vBox.getChildren().add(e);
		return vBox;
	}
	
	public static HBox loadNodesAsHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		
		for (Node e : nodes)
			hBox.getChildren().add(e);
		return hBox;
	}
	
	public static void switchToSignUpPane(LoginPane loginPane) {
		Stage stage = (Stage) loginPane.getScene().getWindow();
		stage.setTitle("Sign Up");
		stage.setWidth(USER_WIDTH);
		stage.setHeight(USER_HEIGHT);
		BorderPane root = (BorderPane) loginPane.getScene().getRoot();
		root.setCenter(new SignUpPane(loginPane.getUserAccountBag()));
	}
	
	public static void switchToLoginPane(SignUpPane signUpPane) {
		Stage stage = (Stage) signUpPane.getScene().getWindow();
		stage.setTitle("Login");
		stage.setWidth(USER_WIDTH);
		stage.setHeight(USER_HEIGHT);
		BorderPane root = (BorderPane) signUpPane.getScene().getRoot();
		root.setCenter(new LoginPane(signUpPane.getUserAccountBag()));
	}
}
