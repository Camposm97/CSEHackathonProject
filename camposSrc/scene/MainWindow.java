package scene;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Name;
import model.User;
import scene.layout.HeaderPane;
import util.CamposUtil;
import util.ImgUtil;

/**
 * Stage is displayed here root (BorderPane) is set with panes on initialization.
 * @author Camposm97
 */
public class MainWindow {
	/*
	 * root will have a menu bar as top pane carrying the controls to browse friends, have a logo of my space (WIP)
	 */
	private BorderPane root;
	private Scene scene;
	
	public MainWindow(Stage stage) {
		this.root = new BorderPane(null, new HeaderPane(new User("Camposm", new Name("Michael", "Campos"), "Go Away")), null, null, null);
		this.scene = new Scene(root);
		ImgUtil.loadStageIcon(stage);
		stage.setScene(scene);
		stage.setTitle(CamposUtil.TITLE);
		stage.show();
	}
}
