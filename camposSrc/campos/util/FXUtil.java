package campos.util;

import java.util.ArrayList;

import campos.models.Gender;
import campos.models.Major;
import campos.scene.control.MyLabel;
import campos.scene.layout.LoginPane;
import campos.scene.layout.SignUpPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXUtil {
	public static final String TITLE = "Connect v1.0"; // Because you'll only connect with one person with this app
	public static final Insets DEFAULT_INSETS = new Insets(10);
	public static final double BT_WIDTH = 86;
	
	public static ArrayList<Image> loadAvatarImages() {
		final int SIZE = 7;
		ArrayList<Image> list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			Image image = ImgUtil.loadImg("resources/images/avatars/" + String.valueOf(i) + ".jpg");
//			System.out.println(image.getWidth() + " | " + image.getHeight());
			list.add(image);
		}
		return list;
	}

	public static VBox asVBox(Node... nodes) {
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		for (Node e : nodes)
			vBox.getChildren().add(e);
		return vBox;
	}
	
	public static HBox asHBox(Node... nodes) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		for (Node e : nodes)
			hBox.getChildren().add(e);
		return hBox;
	}

	public static StackPane asStackPane(Node node) {
		StackPane stackPane = new StackPane(node);
		stackPane.setPadding(DEFAULT_INSETS);
		return stackPane;
	}

	public static ComboBox<Gender> loadCbGender() {
		ComboBox<Gender> cb = new ComboBox<>();
		cb.setValue(Gender.Male);
		for (int i = 0; i < Gender.values().length; i++) {
			cb.getItems().add(Gender.values()[i]);
		}
		return cb;
	}

	public static ComboBox<Major> loadCbMajor() {
		ComboBox<Major> cb = new ComboBox<>();
		cb.setValue(Major.CSE);
		for (int i = 0; i < Major.values().length; i++) {
			cb.getItems().add(Major.values()[i]);
		}
		return cb;
	}

	public static MyLabel loadLblTitle() {
		DropShadow ds = new DropShadow();
		ds.setOffsetY(10.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		MyLabel lbl = new MyLabel(TITLE, Color.BLACK, 32);
		lbl.setFont(Font.font("Comic Sans MS", 32));
		lbl.setEffect(ds);
		return lbl;
	}

	public static void toSignUpPane(LoginPane loginPane) {
		Stage stage = (Stage) loginPane.getScene().getWindow();
		stage.setTitle("Sign Up");
		BorderPane root = (BorderPane) loginPane.getScene().getRoot();
		root.setCenter(new SignUpPane());
	}

	public static void toLoginPane(SignUpPane signUpPane) {
		Stage stage = (Stage) signUpPane.getScene().getWindow();
		stage.setTitle("Login");
		BorderPane root = (BorderPane) signUpPane.getScene().getRoot();
		root.setCenter(new LoginPane());
	}
}
