package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.UserAccountBag;
import utilities.EventLoader;
import utilities.FXLoader;
import utilities.UserAccountFactory;
import view.LoginPane;

public class Main extends Application {
	private static final int MAX_ACCOUNTS = 10;
	private UserAccountBag userBag;
	private LoginPane loginPane;
	private BorderPane root;
	
	@Override
	public void init() {
		userBag = new UserAccountFactory().loadUserAccountBagSorted(MAX_ACCOUNTS);
		userBag.display();
		loginPane = new LoginPane(userBag);
		root = new BorderPane(loginPane);
		EventLoader.loadEscKey(root);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setScene(new Scene(root));
		stage.setWidth(FXLoader.USER_WIDTH);
		stage.setHeight(FXLoader.USER_HEIGHT);
		stage.setTitle("Login");
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
