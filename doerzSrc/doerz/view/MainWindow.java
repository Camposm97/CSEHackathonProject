package doerz.view;

import java.util.LinkedList;

import campos.models.UserAccount;
import doerz.model.Post;
import doerz.view.layout.ComposePane;
import doerz.view.layout.FeedPane;
import doerz.view.layout.ProfilePane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow {

	public MainWindow(Stage stage, UserAccount user) {
		BorderPane root = new BorderPane();
		BorderPane nest = new BorderPane();
		root.setCenter(nest);
		Scene scene = new Scene(root, 750, 650);
		
		LinkedList<Post> feed = new LinkedList<Post>();
		new ComposePane(nest, stage, user);
		new FeedPane(nest, stage, feed);
		new ProfilePane(root, stage);
		
		stage.setScene(scene);
		stage.show();
	}
}
