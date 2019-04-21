package util;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXUtil {
	public static final String BACKGROUND_COLOR = "#2474DF";
	public static final Insets DEFAULT_INSETS = new Insets(10);
	
	public static VBox asVBox(Node...nodes) {
		VBox vBox = new VBox();
		for (Node node : nodes) {
			vBox.getChildren().add(node);
		}
		return vBox;
	}
	
	public static HBox asHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		for (Node node : nodes) {
			hBox.getChildren().add(node);
		}
		return hBox;
	}
}
