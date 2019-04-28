package doerz.view.layout;

import campos.models.UserAccount;
import doerz.model.Post;
import doerz.view.UserWindow;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.Dummy;

/*
 * This builds a low-tech "post editor" that allows users write and post things into the feed.
 * 
 * Because this isn't tied into any user account functionality yet, I have provided a means of
 * creating a userAccount to attach to posts that are created. 
 * If no user is created, a default one is automatically provided for each post.
 */

public class ComposePane {
//	private TextField composeField; 
	private TextArea composeArea;
	private Button postBtn, userBtn;
	private UserAccount user;
	private GridPane grid;
	
	public ComposePane(BorderPane root, Stage stage) {
		initializeNodes();
		drawGrid();
		root.setCenter(grid);
		autoSizeMsg();
		callBacks();
	}
	
	private void initializeNodes() {
		userBtn = new Button("New Account");
		composeArea = new TextArea();
		composeArea.setPromptText("Write something!");
		composeArea.setPrefHeight(60);
		composeArea.setMinWidth(400);						// Magic number - Defines width of the textField
		postBtn = new Button("Post");		
	}

	private void drawGrid() {
		grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.add(userBtn, 1, 0);
		grid.add(composeArea, 0, 1);
		grid.add(postBtn, 1, 1);
		
		Separator sep = new Separator();
		grid.add(sep, 0, 2, 2, 1);
	}

	/*
	 * This method increases the height of the textArea used to compose a post.
	 */
	private void autoSizeMsg() {
		SimpleIntegerProperty count=new SimpleIntegerProperty(50);
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
			
			if(user == null) { 
				// Generate default dummy account if none provided by user
				newPost = new Post(message, Dummy.getDummyAcc("defaultUser"));
			} else {
				// Use user provided account.
				newPost = new Post(message, user);
			}
			System.out.println(composeArea.getHeight());
			
			FeedPane.addToFeed(newPost, composeArea.getHeight());
			composeArea.setPrefHeight(60);
			clearAll();
		});
		userBtn.setOnAction(e -> {
			user = Dummy.getDummyAcc("def"); // "def" is a default username. This is provided to avoid a nullPointer.
			new UserWindow(user);
		});
	}
	
	private void clearAll() {
//		composeField.clear();
		composeArea.clear();
	}
}
