package doerz.view;

import java.util.LinkedList;

import campos.models.UserAccount;
import doerz.model.Post;
import doerz.view.layout.ComposePane;
import doerz.view.layout.FeedPane;
import doerz.view.layout.HeaderPane;
import doerz.view.layout.ProfilePane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow {
	
	/*
	 * MainWindow is the hub that controls what is displayed as the home screen.
	 * After being successfully logged in, users should be sent here. 
	 * 
	 * Pass in the app's primary stage as well as the successful login account.
	 */

	public MainWindow(Stage stage, UserAccount user) {
		BorderPane root = new BorderPane();
		BorderPane nest = new BorderPane();
		root.setCenter(nest);
		Scene scene = new Scene(root, 950, 850);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
		LinkedList<Post> feed = new LinkedList<Post>();
		nest.setCenter(new ComposePane(user).getNode());
		nest.setBottom(new FeedPane(feed).getNode());
		new ProfilePane(root);
		new HeaderPane(root, stage);
		
	}
}
