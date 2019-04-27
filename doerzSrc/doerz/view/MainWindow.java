package doerz.view;

import java.util.LinkedList;

import doerz.model.Post;
import doerz.view.layout.ComposePane;
import doerz.view.layout.FeedPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow {

	public MainWindow(Stage stage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 650);
		
//		int feedLength = 10;
		LinkedList<Post> feed = new LinkedList<Post>();
		new ComposePane(root, stage);
		new FeedPane(root, stage, feed);
		
		stage.setScene(scene);
		stage.show();
	}
}
