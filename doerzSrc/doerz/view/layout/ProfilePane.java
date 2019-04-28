package doerz.view.layout;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * This is a placeholder for the profile pane that will display to the left of the feed.
 * 
 */

public class ProfilePane {
	
	public ProfilePane(BorderPane root, Stage stage) {
		Pane pane = new BorderPane();
		pane.setMinWidth(100);
		pane.setMinHeight(500);
		pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		root.setLeft(pane);
	}
}
