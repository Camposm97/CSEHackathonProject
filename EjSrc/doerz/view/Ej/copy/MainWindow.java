package doerz.view.Ej.copy;

import java.util.LinkedList;

import campos.models.UserAccount;
import campos.util.ImgUtil;
import doerz.collection.FollowedFeed;
import doerz.model.Post;
import doerz.view.layout.ComposePane;
import doerz.view.layout.FeedPane;
import doerz.view.layout.HeaderPane;
import doerz.view.layout.Ej.Copy.ProfilePane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow {
	
	/*
	 * MainWindow is the hub that controls what is displayed as the home screen.
	 * After being successfully logged in, users should be sent here. 
	 * 
	 * Pass in the successful login account.
	 */

	public MainWindow(UserAccount user) {
		BorderPane root = new BorderPane();
		BorderPane nest = new BorderPane();
		root.setCenter(nest);
		Scene scene = new Scene(root, 1000, 850);
		Stage stage = new Stage();
		ImgUtil.loadStageIcon(stage);
		stage.setTitle("Connect");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
//		LinkedList<Post> feed = user.getPostList();
		LinkedList<Post> feed = FollowedFeed.getFeedPosts(user);

		nest.setCenter(new ComposePane(user).getNode());
		nest.setBottom(new FeedPane(feed).getNode());
		root.setLeft(new ProfilePane(user).getNode());
		new HeaderPane(root, stage);
		
	}
}
