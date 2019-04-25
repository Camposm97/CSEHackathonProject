package campos.scene.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonSignUp extends Button {
	public ButtonSignUp() {
		super("Sign Up");
		setOnAction(new SignUpHandler());
	}
	
	private class SignUpHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			
		}
	}
}
