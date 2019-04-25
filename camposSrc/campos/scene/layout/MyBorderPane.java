package campos.scene.layout;

import campos.event.EventLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class MyBorderPane extends BorderPane {
	public MyBorderPane(Node node) {
		super(node);
		EventLoader.loadEscKey(this);
	}
	
	public MyBorderPane(Node center, Node top, Node right, Node bottom, Node left) {
		super(center, top, right, bottom, left);
		EventLoader.loadEscKey(this);
	}
}
