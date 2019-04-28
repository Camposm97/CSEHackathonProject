package doerz.view.layout;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * This is a placeholder for the profile pane that will display to the left of the feed.
 * 
 */

public class ProfilePane {
	
	private ImageView image;
	private Label userLbl;
	private Hyperlink editLbl;
	private GridPane pane;
	
	public ProfilePane(BorderPane root, Stage stage) {
		
		initializeNodes();
		drawPane(root);
		
	}

	private void drawPane(BorderPane root) {
		pane = new GridPane();
		pane.setPadding(new Insets(10));
		pane.setVgap(5);
		pane.setHgap(5);
		pane.setMinWidth(175);
		pane.setMinHeight(500);
		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		pane.add(image, 0, 0);
		pane.add(userLbl, 1, 0);
		GridPane.setValignment(userLbl, VPos.TOP);
		pane.add(gridRow(10), 0, 1);
		pane.add(editLbl, 0, 2);
		
		root.setLeft(pane);		
	}

	private void initializeNodes() {
		getAvatar();
		userLbl = new Label("Your Name");
		userLbl.setMinWidth(50);
		userLbl.setStyle("-fx-font-size: 14");
		editLbl = new Hyperlink("Edit profile");
		editLbl.setStyle("-fx-font-size: 10");
		editLbl.setMinWidth(50);
	}

	private void getAvatar() {
		image = new ImageView();
		File file = new File("resources/AvatarTemp.jpg");
		Image avatar = new Image(file.toURI().toString());
		image.setImage(avatar);
	}
	
	private Pane gridRow(double minHeight) {
		Pane row = new Pane();
		row.setMinWidth(minHeight);
		return row;
	}
}
