package doerz.view;

import doerz.view.layout.ComposePane;
import doerz.view.layout.FeedPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MsgWindow {

	public MsgWindow(Stage stage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 600);
		
		
		
		ComposePane compose = new ComposePane(root, stage);
		FeedPane feed = new FeedPane(root, stage);
		
		stage.setScene(scene);
		stage.show();
	}
}
