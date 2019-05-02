package campos.scene.control;

import campos.scene.layout.AvatarPicker;
import javafx.scene.control.Button;

public class ButtonAvatar extends Button {
	private AvatarPicker avatarPicker;
	
	public ButtonAvatar() {
		super("Pick my Avatar");
		this.avatarPicker = new AvatarPicker();
		this.setOnAction(e -> {
			avatarPicker = new AvatarPicker();
			avatarPicker.showAndWait();
		});
	}
	
	public AvatarPicker getAvatarPicker() {
		return avatarPicker;
	}
}	
