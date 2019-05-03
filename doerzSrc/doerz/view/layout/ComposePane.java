package doerz.view.layout;

import campos.models.UserAccount;
import doerz.model.Message;
import doerz.model.Post;
import doerz.view.UserWindow;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.Dummy;

/*
 * This builds a low-tech "post editor" that allows users write and post things into the feed.
 * 
 * Because this isn't tied into any user account functionality yet, I have provided a means of
 * creating a developer userAccount to attach to posts that are created. 
 * If no user is created, a default one is automatically provided for each post.
 */

public class ComposePane {
	private TextArea composeArea;
	private Button postBtn, userBtn;
	private ToggleButton boldBtn;
	private UserAccount devUser, user;
	private GridPane grid;
	private BorderPane container;
	
	public ComposePane(UserAccount user) {
		this.user = user;
		
		initializeNodes();
		drawGrid();
		
		container = new BorderPane();
		container.setCenter(grid);
		
		autoSizeMsg();
		callBacks();
	}
	
	public BorderPane getNode() {
		return container;
	}
	
	private void initializeNodes() {
		userBtn = new Button("New Dev User");	// For development
		composeArea = new TextArea();
		composeArea.setPromptText("Write something!");
		composeArea.setPrefHeight(60);
		composeArea.setMinWidth(600);			
		postBtn = new Button("Post");		
		postBtn.setPrefSize(60, 50);
		
//		boldBtn = new ToggleButton("B");
	}

	private void drawGrid() {
		grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setHgap(10);
		grid.setVgap(10);
		
//		grid.add(boldBtn, 0, 0);
		
		grid.add(userBtn, 1, 0);
		GridPane.setHalignment(userBtn, HPos.RIGHT);
		grid.add(composeArea, 0, 1);
		grid.add(postBtn, 1, 1);
		GridPane.setValignment(postBtn, VPos.TOP);
		
		Separator sep = new Separator();
		grid.add(sep, 0, 2, 2, 1);
	}

	/*
	 * This method automatically resizes the post editor as you type to prevent scrolling.
	 */
	private void autoSizeMsg() {
		SimpleIntegerProperty count = new SimpleIntegerProperty(50);
		int rowHeight = 10;

		composeArea.prefHeightProperty().bindBidirectional(count);
		composeArea.minHeightProperty().bindBidirectional(count);
		composeArea.scrollTopProperty().addListener((ov, oldVal, newVal) -> {
		    if(newVal.intValue() > rowHeight){
		        count.setValue(count.get() + newVal.intValue());
		    }
		});
	}

	private void callBacks() {
		postBtn.setOnAction(e -> {
			String message = composeArea.getText();
			Post newPost = null;
			
			// The following determines the author of a post when submitted.
			if(devUser != null) {
				// devUser overrides login account.
				newPost = new Post(message, composeArea.getHeight(), devUser);
			} else {
				// login user account.
				newPost = new Post(message, composeArea.getHeight(), user);
			}
			FeedPane.addToFeed(newPost);
			resetTextArea();
		});
		
		userBtn.setOnAction(e -> {
			// "def" is a default username. This is provided to avoid a nullPointer 
			// if window is closed with no input.
			devUser = Dummy.getDummyAcc("def"); 
			new UserWindow(devUser);
		});
		
//		boldBtn.setOnAction(e -> {
//			composeArea.setF
//		});
	}
	
	private void resetTextArea() {
		composeArea.setPrefHeight(60);
		clearAll();
	}

	private void clearAll() {
		composeArea.clear();
	}
}
