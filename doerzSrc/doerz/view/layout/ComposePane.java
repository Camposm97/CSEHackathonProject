package doerz.view.layout;

import campos.models.UserAccount;
import doerz.model.Post;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/*
 * This builds a low-tech "post editor" that allows users write and post things into the feed.
 * 
 * Because this isn't tied into any user account functionality yet, I have provided a means of
 * creating a developer userAccount to attach to posts that are created. 
 * If no user is created, a default one is automatically provided for each post.
 */

public class ComposePane {
	private TextArea composeArea;
	private Button postBtn, refBtn;
	private UserAccount user;
	private GridPane grid;
	private BorderPane container;
	
	public ComposePane(UserAccount user) {
		this.user = user;
		
		initializeNodes();
		validationStatus();	// Controls the disableProperty of the postBtn
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
		composeArea = new TextArea();
		composeArea.setPromptText("Write something!");
		composeArea.setPrefHeight(60);
		composeArea.setMinWidth(600);			
		postBtn = new Button("Post");		
		postBtn.setPrefSize(60, 50);
		
		refBtn = new Button("Refresh");
	}

	private void drawGrid() {
		grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.add(refBtn, 0, 3);
		
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
//			System.out.println("---");
			String message = composeArea.getText();
			Post newPost = null;
			
			newPost = new Post(message, composeArea.getHeight(), user);
//			user.getPostList().add(newPost);
			
			FeedPane.addToFeed(newPost);
			
			resetTextArea();
		});
		
		
		refBtn.setOnAction(e -> {
			FeedPane.refresh();
		});
	}
	
	private void resetTextArea() {
		composeArea.setPrefHeight(60);
		clearAll();
	}

	private void clearAll() {
		composeArea.clear();
	}
	
	// This method binds the textArea with the postBtn, keeping the button disabled if no text is present.
	private void validationStatus() {
		BooleanBinding disableBtn = Bindings.not(composeArea.textProperty().isNotEmpty());
		postBtn.disableProperty().bind(disableBtn);
	}
}
