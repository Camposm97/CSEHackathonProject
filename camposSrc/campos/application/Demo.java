package campos.application;

import campos.models.UserAccountBag;
import campos.scene.layout.LoginPane;
import campos.util.EventLoader;
import campos.util.FXUtil;
import campos.util.ImgUtil;
import campos.util.UserAccountFactory;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo extends Application {
	private static final int MAX_ACCOUNTS = 20;
	private UserAccountBag userBag;
	private BorderPane root;
	
	@Override
	public void init() {
		userBag = UserAccountFactory.loadUserAccountBag(MAX_ACCOUNTS);
		root = new BorderPane(new LoginPane(userBag));
		EventLoader.loadEscKey(root);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setScene(new Scene(root));
		stage.setWidth(FXUtil.USER_WIDTH);
		stage.setHeight(FXUtil.USER_HEIGHT);
		stage.setTitle("Login");
		stage.setResizable(false);
		ImgUtil.loadStageIcon(stage);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
