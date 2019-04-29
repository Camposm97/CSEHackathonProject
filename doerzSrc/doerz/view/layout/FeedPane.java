package doerz.view.layout;

import java.util.LinkedList;

import doerz.model.Post;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
	
	public FeedPane(BorderPane root, LinkedList<Post> feed) {
		FeedPane.feed = feed;
		
		initilizePanes();
		scrollPaneSettings();
		devOperations(root);	// for debugging
		callBacks();
	
		root.setBottom(scrlPane);
	}
	
	private void devOperations(BorderPane root) {
		HBox box = new HBox();
//		box.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
//				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		clrBtn = new Button("Clear Feed View");						
		clrDataBtn = new Button("Delete All Posts");				
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
		scrlPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrlPane.setMaxHeight(500);
        scrlPane.setPrefHeight(450);
	}

	private void callBacks() {
		clrBtn.setOnAction(e -> {		// Clear messages from viewport. Does NOT delete data. -For debugging
			feedBox.getChildren().clear();
		});
		clrDataBtn.setOnAction(e -> {	// Deletes all currently stored messages. -For debugging
			feed.clear();
		});
	}
	
	public static void addToFeed(Post post) {
		/*
		 * Server Interaction should be written here, replacing the next line of code. 
		 * Send the post to the server, where it is appended into the LinkedList, then sent
		 * back to the client to be read and displayed on their GUI.
		 */
		feed.add(post);	// Line to be replaced
		refresh();
	}
	
	public static void refresh() {
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
			PostView newPost = new PostView(p);
			feedBox.getChildren().add(0, newPost.getPost());
		}
	}

}
