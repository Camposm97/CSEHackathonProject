package doerz.demo;

import doerz.view.MsgWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MessageDemo extends Application{

	public static void main(String[] args) {

	}

	@Override
	public void start(Stage stage) throws Exception {
		new MsgWindow(stage);
	}

}
