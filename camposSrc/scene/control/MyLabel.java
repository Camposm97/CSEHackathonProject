package scene.control;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyLabel extends javafx.scene.control.Label {
	
	public MyLabel(String text, Color color, int fontSize) {
		super(text);
		this.setTextFill(color);
		this.setFont(Font.font(fontSize));
	}
}
