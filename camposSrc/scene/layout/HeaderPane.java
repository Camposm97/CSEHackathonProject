package scene.layout;


import campos.scene.control.MyLabel;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.User;
import util.CamposUtil;
import util.FXUtil;
import util.ImgUtil;

public class HeaderPane extends BorderPane {
	private User user;
	
	public HeaderPane(User user) {
		this.user = user;
		new HeaderPaneUtil(this);
	}
	
	private class HeaderPaneUtil {
		public HeaderPaneUtil(HeaderPane root) {
			root.setStyle("-fx-background-color: " + FXUtil.BACKGROUND_COLOR + ";");
			root.setLeft(loadTitleFX());
			root.setCenter(loadUserHeading(user));
		}
		
		public HBox loadTitleFX() {
			MyLabel lblTitle = new MyLabel(CamposUtil.TITLE_HEADING, Color.WHITE, 32);
			MyLabel lblLogo = new MyLabel(CamposUtil.LOGO, Color.WHITE, 12);
			VBox vBox = FXUtil.asVBox(lblTitle,lblLogo);
			vBox.setAlignment(Pos.CENTER_RIGHT);
			
			HBox hBox = FXUtil.asHBox(ImgUtil.loadImgView(ImgUtil.ICON_MAIN), vBox);
			hBox.setPadding(FXUtil.DEFAULT_INSETS);
			return hBox;
		}
		
		public HBox loadUserHeading(User user) {
			MyLabel lblUser = new MyLabel(user.getUsername(), Color.WHITE, 12);
			MyLabel lblStatus = new MyLabel(user.getStatus(), Color.WHITE, 12);
			
			VBox vBox = FXUtil.asVBox(lblUser, lblStatus);
			
			HBox hBox = FXUtil.asHBox(vBox);
			return hBox;
		}
	}
}
