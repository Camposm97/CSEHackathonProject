package Date.Picker;

import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class DatePickerSample extends Application {
 
    private Stage stage;
    private DatePicker checkInDatePicker;
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
    	 Locale.setDefault(Locale.US);
        this.stage = stage;
        stage.setTitle("My Calender");
        initUI();
        stage.show();
    }
 
    private void initUI() {
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);

        checkInDatePicker = new DatePicker();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label checkInlabel = new Label("Date You Want To Contact: ");
        Label nameLabel = new Label("Name: ");
        Label emailLabel = new Label("Email: ");
        TextField name = new TextField();
        name.setPromptText("John Doe");
        TextField email = new TextField();
        email.setPromptText("JohnDoe@email.com");
        gridPane.add(nameLabel, 0, 2);
        gridPane.add(emailLabel, 0, 4);
        gridPane.add(name, 0,3 );
        gridPane.add(email, 0, 5);
        gridPane.add(checkInlabel, 0, 0);

        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(checkInDatePicker, 0, 1);
        vbox.getChildren().add(gridPane);
    }
}
