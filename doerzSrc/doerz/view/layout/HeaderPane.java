package doerz.view.layout;


import campos.util.ImgUtil;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	private ImageView imageV;
	private TextField searchTf;
	private Button logoutBtn, searchBtn;
	private HBox hRoot;
	private Stage stage;
	
	/*
	 * Sloppy code is sloppy. Will refactor eventually. Places a header on the MainWindow.
	 * Not functional.
	 */
	
	public HeaderPane(BorderPane root, Stage stage) {
		this.stage = stage;
		initializeNodes();
		drawPane(root, stage);
		callBacks();
	}

	private void callBacks() {
		logoutBtn.setOnAction(e -> {
			Platform.exit();
		});
		
		searchBtn.setOnAction(e -> {
			searchFunction();
		});
	}

	private void searchFunction() {
		String key = searchTf.getText();
		/*
		 * write key to server
		 * read list back
		 * 
		 * send list to feedPane
		 */
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
		logo.getChildren().add(imageV);
		logo.setAlignment(Pos.CENTER_LEFT);
		
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
		imageV = ImgUtil.loadImgV(ImgUtil.ICON_MAIN);
		imageV.setFitHeight(40);
		imageV.setFitWidth(40);
	}
}
