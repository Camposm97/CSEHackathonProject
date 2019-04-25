package doerz.view.layout;

import doerz.model.Post;
import doerz.model.PostQueue;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.Dummy;

/*
 * Wrote this mainly as proof of concept. All of the testing lines are there to make sure
 * things are working and aren't necessarily part of the final design.
 */

public class FeedPane {
	private Button clrBtn, clrDataBtn;									// testing
	private ScrollPane scrlPane;
	private static VBox feedBox;
	private static PostQueue feed;
	
	public FeedPane(BorderPane root, Stage stage, PostQueue feed) {
		this.feed = feed;
		feedBox = new VBox();
		scrlPane = new ScrollPane();
		scrollPaneSettings();
		
		HBox box = new HBox();
		clrBtn = new Button("Clear Feed View");						// testing
		clrDataBtn = new Button("Remove All Posts");		
		box.getChildren().addAll(clrBtn, clrDataBtn);
		
		callBack();
	
		root.setTop(box);
		root.setBottom(scrlPane);
	}

	private void scrollPaneSettings() {
		scrlPane.setContent(feedBox);
		scrlPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrlPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrlPane.setMaxHeight(500);
	}

	private void callBack() {
		// testing	-  The dummy button will generate a new dummy post and add it to the feed.
		clrBtn.setOnAction(e -> {
//			Post dummyPost = Dummy.makeDummyPost();
//			addToFeed(dummyPost);
			feedBox.getChildren().clear();
		});
		clrDataBtn.setOnAction(e -> {
			feed.reset();
		});
	}
	
	public static void addToFeed(Post post) {
		feed.add(post);
//		PostView newPost = new PostView(post);
//		feedBox.getChildren().add(0, newPost.getPost());
		refresh();
	}
	
	public static void refresh() {
		feedBox.getChildren().clear();
		for(Post p : feed.toArray()) {
			PostView newPost = new PostView(p);
			feedBox.getChildren().add(0, newPost.getPost());
		}
	}

}
