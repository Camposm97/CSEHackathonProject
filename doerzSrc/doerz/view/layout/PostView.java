package doerz.view.layout;

import doerz.model.Post;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/*
 * This class takes a post object (a String message written by some userAccount author) and constructs it
 * into something that can be displayed on a GUI. 
 * 
 * Specifically, it formats the post's fields onto a gridPane that can then be displayed on the FeedPane.
 */

public class PostView {
	private Label authorLbl, idLbl;
	private TextArea msgBdy;
	private GridPane grid;
	
	public PostView(Post post){
		grid = new GridPane();
		grid.setVgap(10);
		grid.setPadding(new Insets(20));		
		grid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		
		GridPane body = new GridPane();
		drawBody(body, post);
		
		GridPane header = new GridPane();
		drawHeader(header, post);
		
		grid.add(header, 0, 0, 2, 1);
		grid.add(body, 0, 1);
		
	}
	
	// Builds the header of the post from author's information
	private void drawHeader(GridPane header, Post post) {
		authorLbl = new Label(post.getAuthor().getUsername());
		idLbl = new Label(post.getId());
		
		header.add(authorLbl, 0, 0);
		header.add(idLbl, 2, 0);
		header.add(gridColumn(400), 1, 0);
	}
	
	// Builds the body of the post from the composed message
	private void drawBody(GridPane body, Post post) {
		msgBdy = new TextArea();
		msgBdy.setText(post.getMessage());
		msgBdy.setPrefHeight(30);
		body.add(msgBdy, 0, 0);
	}
	
	// Used to create a blank column in a gridPane
	private Pane gridColumn(double minWidth) {
		Pane column = new Pane();
		column.setMinWidth(minWidth);
		return column;
	}
	
	// Returns the post as a pane that can be displayed on the GUI.
	public GridPane getPost() {
		return grid;
	}
}
