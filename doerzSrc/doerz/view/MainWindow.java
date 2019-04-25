package doerz.view;

import doerz.model.PostQueue;
import doerz.view.layout.ComposePane;
import doerz.view.layout.FeedPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow {

	public MainWindow(Stage stage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 600);
		
		int feedLength = 10;
		PostQueue feed = new PostQueue(feedLength);
		new ComposePane(root, stage);
		new FeedPane(root, stage, feed);
		
		stage.setScene(scene);
		stage.show();
	}
}
