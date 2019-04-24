package doerz.view.layout;

import campos.models.UserAccount;
import doerz.model.Post;
import doerz.view.UserWindow;
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
	private TextField composeField, userNameField;
	private Button postBtn, userBtn;
	private UserAccount user;
	
	public ComposePane(BorderPane root, Stage stage) {
		GridPane grid = new GridPane();
		root.setCenter(grid);
		grid.setPadding(new Insets(20));
		grid.setHgap(10);
		grid.setVgap(10);
		
//		userNameField = new TextField("NewUser");
//		userNameField.setPrefWidth(100);
		userBtn = new Button("New Account");
		
		composeField = new TextField();
		composeField.setPromptText("Write something!");
		composeField.setMinWidth(300);						// Magic number
		
		postBtn = new Button("Post");
		
		grid.add(userBtn, 1, 0);
		grid.add(composeField, 0, 1);
		grid.add(postBtn, 1, 1);
		
		Separator sep = new Separator();
		grid.add(sep, 0, 2, 2, 1);
		
		callBacks();
		
	}

	private void callBacks() {
		postBtn.setOnAction(e -> {
			String message = composeField.getText();
			Post newPost = null;
			
			if(user == null) {
				newPost = new Post(message, Dummy.getDummyAcc("defaultUser"));
			} else {
				newPost = new Post(message, user);
			}
			
			FeedPane.addToFeed(newPost);
			clearAll();
		});
		userBtn.setOnAction(e -> {
			user = Dummy.getDummyAcc("def");
			new UserWindow(user);
		});
	}
	
	private void clearAll() {
		composeField.clear();
	}
}
