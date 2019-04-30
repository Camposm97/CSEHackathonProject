package doerz.view.layout;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HeaderPane {
	private ImageView image;
	private TextField searchTf;
	private Button logoutBtn, searchBtn;
	private HBox hRoot;
	
	/*
	 * Sloppy code is sloppy. Will refactor eventually. Places a header on the MainWindow.
	 * Not functional.
	 */
	
	public HeaderPane(BorderPane root, Stage stage) {
		initializeNodes();
		drawPane(root, stage);
		callBacks();
	}

	private void callBacks() {
		logoutBtn.setOnAction(e -> {
			
		});
		
		searchBtn.setOnAction(e -> {
			
		});
	}

	private void drawPane(BorderPane root, Stage stage) {
		hRoot = new HBox();
		HBox logo = new HBox();
		HBox search = new HBox();
		HBox logout = new HBox();
		hRoot.setPadding(new Insets(5));
		logo.setPrefWidth(stage.getWidth() / 5);
		search.setPrefWidth(stage.getWidth() / 2);
		logout.setPrefWidth(stage.getWidth() / 4);
		hRoot.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		logo.getChildren().add(image);
		logo.setAlignment(Pos.CENTER);
		
		search.getChildren().addAll(searchTf, searchBtn);
		search.setAlignment(Pos.CENTER_LEFT);
		
		logout.getChildren().add(logoutBtn);
		logout.setAlignment(Pos.CENTER_RIGHT);
		
		hRoot.getChildren().addAll(logo, search, logout);
		
		root.setTop(hRoot);
		
	}
	
	private Pane gridRow(double minHeight) {
		Pane row = new Pane();
		row.setMinWidth(minHeight);
		return row;
	}

	private void initializeNodes() {
		drawLogo();
		searchTf = new TextField();
		searchTf.setPromptText("Search");
		searchTf.setPrefWidth(300);
		logoutBtn = new Button("Sign out");
		searchBtn = new Button("Search");
		
	}

	private void drawLogo() {
		image = new ImageView();
		File file = new File("resources/images/icons/puzzle.png");
		Image avatar = new Image(file.toURI().toString());
		image.setImage(avatar);		
		image.setFitHeight(40);
		image.setFitWidth(40);
	}
}
