package campos.workbench.network.textbook;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {
  // IO streams
	
  private DataOutputStream toServer = null;
  private DataInputStream fromServer = null;

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Panel p to hold the label and text field
    BorderPane paneForTextField = new BorderPane();
    paneForTextField.setPadding(new Insets(5, 5, 5, 5)); 
    paneForTextField.setStyle("-fx-border-color: green");
    paneForTextField.setLeft(new Label("Enter a Username: "));
    
    TextField tf = new TextField();
    tf.setAlignment(Pos.BOTTOM_RIGHT);
    paneForTextField.setCenter(tf);
    
    Button button = new Button("Send");
    button.setOnAction(e ->{
    	
    });
    paneForTextField.getChildren().add(button);
    
    BorderPane mainPane = new BorderPane();
    // Text area to display contents
    TextArea ta = new TextArea();
    mainPane.setCenter(new ScrollPane(ta));
    mainPane.setTop(paneForTextField);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(mainPane, 450, 200);
    primaryStage.setTitle("Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    tf.setOnAction(e -> {
      try {
<<<<<<< HEAD
        // Get the message from the text field
=======
        // Get the radius from the text field
<<<<<<< HEAD
       // double radius = Double.parseDouble(tf.getText().trim());
    	  ta.appendText("Please Enter a Username");
        // Send the radius to the server
       // toServer.writeDouble(radius);
       // toServer.flush();
=======
>>>>>>> 22bb0185db31acb594b278cc743e6665929596d5
        String message = tf.getText().trim();
  
        // Send the message to the server
        toServer.writeUTF(message + "\n");
        toServer.flush();
>>>>>>> b1ef81883bc0a4121e723b5748f07e9116435c6a
  
        // Get area from the server
        ta.setEditable(false);
        // Display to the text area
<<<<<<< HEAD
     //   ta.appendText("Radius is " + radius + "\n");
        ta.appendText("Area received from the server is "
          + area + '\n');
=======
        ta.appendText(message);
//        ta.appendText("Area received from the server is "
//          + area + '\n');
>>>>>>> b1ef81883bc0a4121e723b5748f07e9116435c6a
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
    });
  
    try {
      // Create a socket to connect to the server
      Socket socket = new Socket("25.5.191.107", 8000);
      // Socket socket = new Socket("130.254.204.36", 8000);
      // Socket socket = new Socket("drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      fromServer = new DataInputStream(socket.getInputStream());

      // Create an output stream to send data to the server
      toServer = new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException ex) {
      ta.appendText(ex.toString() + '\n');
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

