package doerz.view.layout;

import doerz.model.Post;
import doerz.model.PostQueue;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.Dummy;

/*
 * Wrote this mainly as proof of concept. All of the testing lines are there to make sure
 * things are working and aren't necessarily part of the final design.
 */

public class FeedPane {
//	private Button dummyBtn;									// testing
	private ScrollPane scrlPane;
	private static VBox feedBox;
	private static PostQueue feed;
	
	public FeedPane(BorderPane root, Stage stage, PostQueue feed) {
		this.feed = feed;
		feedBox = new VBox();
		scrlPane = new ScrollPane();
		scrollPaneSettings();
		
//		dummyBtn = new Button("Dummy Post");						// testing
		
//		callBack();
	
//		root.setTop(dummyBtn);
		root.setBottom(scrlPane);
	}

	private void scrollPaneSettings() {
		scrlPane.setContent(feedBox);
		scrlPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrlPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrlPane.setMaxHeight(400);
	}

//	private void callBack() {
//		// testing	-  The dummy button will generate a new dummy post and add it to the feed.
//		dummyBtn.setOnAction(e -> {
//			Post dummyPost = Dummy.makeDummyPost();
//			addToFeed(dummyPost);
//		});
//	}
	
	public static void addToFeed(Post post) {
		feed.add(post);
		PostView newPost = new PostView(post);
		feedBox.getChildren().add(0, newPost.getPost());
	}
	
	public static void refresh() {
		feedBox.getChildren().clear();
		for(Post p : feed) {
			
		}
	}

}
