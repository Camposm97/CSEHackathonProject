package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application {

	private static DataOutputStream toServer = null;
	private static DataInputStream fromServer = null;
	private TextField tf;
	
	/*
	 * ENTER SERVER INFO HERE:
	 */
	private static String host = "192.168.1.114";
	private static int port = 7000;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		Scene scene = new Scene(root, 300, 50);		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		try {
			Socket socket = new Socket(host, port);
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(fromServer.readUTF());
		prompt();
		tf = new TextField();
		root.getChildren().addAll(tf);

		tf.setOnAction(e -> {
			String message = userInput();
			toServer(message);
			prompt();
		});

	}
	
	public void prompt() {
		System.out.println("\n>>>Enter new message into textfield\n");
	}
	
	public String userInput() {
		String message = "";
		try {
			message = tf.getText();
			tf.clear();
		} catch (Exception e) {
			
		}
		
		return message;
	}
	
	public void toServer(String message) {
		try {
			toServer.writeUTF(message);
			toServer.flush();
			String reply = fromServer.readUTF();
			System.out.println("Server Echos: \n" + reply);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
