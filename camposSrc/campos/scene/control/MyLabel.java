package campos.scene.control;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyLabel extends Label {
	public MyLabel(String text, Color color, int fontSize) {
		super(text);
		this.setTextFill(color);
		this.setFont(Font.font(fontSize));
	}
	
	public MyLabel(String text, int fontSize) {
		super(text);
		this.setFont(Font.font(fontSize));
	}
}
