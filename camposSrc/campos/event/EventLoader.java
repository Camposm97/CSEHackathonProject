package campos.event;

import javafx.application.Platform;
import javafx.scene.control.ButtonBase;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EventLoader {
	public static void loadEscKey(Pane pane) {
		pane.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ESCAPE)
				Platform.exit();
		});
	}
	
	public static void loadEnterKey(Pane pane, ButtonBase btn) {
		pane.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ENTER)
				btn.fire();
		});
	}
}
