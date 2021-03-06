package doerz.view.layout;

import campos.util.ImgUtil;
import doerz.model.Post;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
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
	private ImageView avatar;
	private Label authorLbl, idLbl, dateLbl;
	private TextArea msgBdy;
	private GridPane grid;
	private double width;
	
	public PostView(Post post){
		this.width = 700;	// default value for post width
		initialize(post);
	}
	
	public PostView(Post post, double width) {
		this.width = width;
		initialize(post);
	}
	
	private void initialize(Post post) {
		drawGrid();
		drawHeader(post);
		drawBody(post);
	}
	
	private void drawGrid() {
		grid = new GridPane();
		grid.setVgap(10);
		grid.setPadding(new Insets(20));		
		grid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	// Builds the header of the post from author's information
	private void drawHeader(Post post) {
		authorLbl = new Label(post.getAuthor().getUsername());
		authorLbl.setStyle("-fx-font-size: 18");
		idLbl = new Label("#" + post.getId() + "  ");
		idLbl.setStyle("-fx-font-size: 8");
		dateLbl = new Label("\t" + post.getDate().toString());
		dateLbl.setStyle("-fx-font-size: 8");
		
//		avatar = new ImageView(post.getAuthor().getImage());
		avatar = ImgUtil.loadImgVR(ImgUtil.DEFAULT_PROFILE, 0.2);
		grid.add(avatar, 0, 0);
		grid.add(authorLbl, 1, 0);
		grid.add(dateLbl, 2, 0);
		grid.add(idLbl, 3, 0);
		GridPane.setHalignment(idLbl, HPos.RIGHT);
	}
	
	// Builds the body of the post from the composed message
	private void drawBody(Post post) {
		msgBdy = new TextArea();
		msgBdy.setPrefHeight(post.getHeight());
		msgBdy.setPrefWidth(width);
		msgBdy.setText(post.getMessage());
		msgBdy.setWrapText(true);
		msgBdy.setEditable(false);
		grid.add(msgBdy, 0, 1, 3, 1);
	}
	
	
	// Used to create a blank column in a gridPane
	// NOT IN USE - will remove when I'm sure I won't use it for anything.
	private Pane gridColumn(double minWidth) {
		Pane column = new Pane();
		column.setMinWidth(minWidth);
		return column;
	}
	
	// Returns the post as a pane that can be displayed on the GUI.
	public GridPane getNode() {
		return grid;
	}
}
