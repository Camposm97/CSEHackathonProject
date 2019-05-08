package doerz.view.layout;


import java.util.LinkedList;

import cabrera.controllers.Controller;
import cabrera.view.Window;
import campos.models.UserAccount;
import campos.util.ImgUtil;
import doerz.view.UserWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * Profile pane displays user's information.
 * 
 */

public class ProfilePane {
	
	private ImageView imageV;
	private static Label userLbl;
	private Label followLbl;
	private Hyperlink editLbl;
	private Button chatBtn;
	private GridPane grid;
	private static UserAccount user;
	private ListView<String> followingView;
	
	
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
		
		chatBtn.setOnAction(e -> {
			Controller.addToList("EJ");
			Controller.addToList("Richard");
			Controller.addToList("Michael");
			
			Stage stage = new Stage();
			new Window(stage);
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
		grid.add(gridRow(50), 0, 3);
		grid.add(followLbl, 0, 4);
		grid.add(followingView, 0, 5, 2, 3);
		
		grid.add(gridRow(50), 0, 8);
		grid.add(chatBtn, 0, 9);
		
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
		
		LinkedList<String> list = new LinkedList<>();
		for(UserAccount u : user.getUserFollowBag()) {
			list.add(u.getUsername());
		}
		ObservableList<String> followed = FXCollections.observableList(list);
		followingView = new ListView<String>(followed);
		followingView.setPrefWidth(100);
		
		followLbl = new Label("Following:");
		
		chatBtn = new Button("Chat");
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
		row.setMinHeight(minHeight);
		return row;
	}
	
	public GridPane getNode() {
		return grid;
	}
}
