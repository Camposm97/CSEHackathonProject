package doerz.view.layout;


import campos.models.UserAccount;
import campos.util.ImgUtil;
import doerz.view.UserWindow;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
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
 * This is a placeholder for the profile pane that will display to the left of the feed.
 * 
 */

public class ProfilePane {
	
	private ImageView imageV;
	private static Label userLbl;
	private Hyperlink editLbl;
	private GridPane grid;
	private static UserAccount user;
	
	public ProfilePane(UserAccount user) {
		ProfilePane.user = user;
		initializeNodes();
		drawPane();
		callBacks();
	}

	private void callBacks() {
		editLbl.setOnAction(e -> {
			new UserWindow(user);
//			refreshNodes();
		});
	}

	public static void refreshNodes() {
		userLbl.setText(user.getUsername());
	}

	private void drawPane() {
		grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setMinWidth(175);
		grid.setMinHeight(500);
		grid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		grid.add(imageV, 0, 0);
		grid.add(userLbl, 1, 0);
		GridPane.setValignment(userLbl, VPos.TOP);
		grid.add(gridRow(10), 0, 1);
		grid.add(editLbl, 0, 2);
		
//		root.setLeft(grid);		
	}

	private void initializeNodes() {
		getAvatar();
		userLbl = new Label(user.getUsername());
		userLbl.setMinWidth(50);
		userLbl.setStyle("-fx-font-size: 14");
		editLbl = new Hyperlink("Edit profile");
		editLbl.setStyle("-fx-font-size: 10");
		editLbl.setMinWidth(50);
	}

	private void getAvatar() {
//		imageV = new ImageView(user.getImage()); 							// Broken
		imageV = new ImageView(ImgUtil.loadImg(ImgUtil.DEFAULT_PROFILE));	// Temp fix
			double ratio = 0.25;
			imageV.setFitWidth(imageV.getImage().getWidth() * ratio);
			imageV.setFitHeight(imageV.getImage().getHeight() * ratio);
	}
	
	private Pane gridRow(double minHeight) {
		Pane row = new Pane();
		row.setMinWidth(minHeight);
		return row;
	}
	
	public GridPane getNode() {
		return grid;
	}
}
