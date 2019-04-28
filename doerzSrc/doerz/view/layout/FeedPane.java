package doerz.view.layout;

import java.util.LinkedList;

import doerz.model.Post;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * All of the debugging lines are there to make sure
 * things are working and aren't necessarily part of the final design.
 */

public class FeedPane {
	
	/*
	 * MESSAGE_VIEW_CAP determines the number of recent messages to display
	 * on the feed.
	 */
	private static final int MESSAGE_VIEW_CAP = 10;
	
	private Button clrBtn, clrDataBtn;	// for debugging								
	private ScrollPane scrlPane;
	private static VBox feedBox;
	private static LinkedList<Post> feed;
	
	public FeedPane(BorderPane root, Stage stage, LinkedList<Post> feed) {
		FeedPane.feed = feed;
		
		initilizePanes();
		scrollPaneSettings();
		devOperations(root);	// for debugging
		callBacks();
	
		root.setBottom(scrlPane);
	}
	
	private void devOperations(BorderPane root) {
		HBox box = new HBox();
		clrBtn = new Button("Clear Feed View");						
		clrDataBtn = new Button("Remove All Posts");				
		box.getChildren().addAll(clrBtn, clrDataBtn);
		root.setTop(box);
	}
	
	private void initilizePanes() {
		feedBox = new VBox();
		scrlPane = new ScrollPane();
	}

	private void scrollPaneSettings() {
		scrlPane.setContent(feedBox);
		scrlPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrlPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrlPane.setMaxHeight(500);
	}

	private void callBacks() {
		clrBtn.setOnAction(e -> {		// Erases messages from viewport. Does NOT delete data. -For debugging
			feedBox.getChildren().clear();
		});
		clrDataBtn.setOnAction(e -> {	// Deletes all currently stored messages. -For debugging
			feed.clear();
		});
	}
	
	public static void addToFeed(Post post, double height) {
		feed.add(post);
		refresh(height);
	}
	
	public static void refresh(double height) {
		feedBox.getChildren().clear();	// Clear messages from viewport
		
		/*
		 * lowerBound: Smallest index of messages to be displayed
		 * upperBound: Largest index of messages to be displayed (ie. most recent message)
		 */
		int lowerBound = 0, upperBound = feed.size(); 
		
		if(feed.size() <= MESSAGE_VIEW_CAP) {
			lowerBound = 0;
		} else {
			lowerBound = upperBound - MESSAGE_VIEW_CAP;
		}
		
		/*
		 *  Iterate through message list and display them in order.
		 *  Will only display the most recent messages.
		 *  "Most Recent" is defined by MESSAGE_VIEW_CAP.
		 *  	ie: Display the last 10 messages in the list, 
		 *  		where 10 is MESSAGE_VIEW_CAP.
		 */
		for(Post p : feed.subList(lowerBound, upperBound)) {
			PostView newPost = new PostView(p, height);
			feedBox.getChildren().add(0, newPost.getPost());
		}
	}

}
