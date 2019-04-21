package campos.scene.control;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CamposLbl extends javafx.scene.control.Label {
	
	public CamposLbl(String text, Color color, int fontSize) {
		super(text);
		this.setTextFill(color);
		this.setFont(Font.font(fontSize));
	}
}
