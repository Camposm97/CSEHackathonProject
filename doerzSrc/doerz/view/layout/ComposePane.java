package doerz.view.layout;

import doerz.model.Post;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.Dummy;

/*
 * This builds a low-tech "post editor" that allows users write and post things into the feed.
 * Because this isn't tied into any user account functionality yet, I've set it up to automatically
 * generate a dummy user account every time you make a new post.
 * (Think of it like creating a new user account for every post you make.)
 */

public class ComposePane {
	private TextField composeField;
	private Button postBtn;
	
	public ComposePane(BorderPane root, Stage stage) {
		GridPane grid = new GridPane();
		root.setCenter(grid);
		grid.setPadding(new Insets(20));
		grid.setHgap(10);
		grid.setVgap(10);
		
		composeField = new TextField();
		composeField.setPromptText("Write something!");
		composeField.setMinWidth(300);						// Magic number
		
		postBtn = new Button("Post");
		
		grid.add(composeField, 0, 0);
		grid.add(postBtn, 1, 0);
		
		Separator sep = new Separator();
		grid.add(sep, 0, 1, 2, 1);
		
		callBacks();
		
	}

	private void callBacks() {
		postBtn.setOnAction(e -> {
			String message = composeField.getText();
			Post newPost = new Post(message, Dummy.getDummyAcc());
			FeedPane.addToFeed(newPost);
			clearAll();
		});
	}
	
	private void clearAll() {
		composeField.clear();
	}
}
