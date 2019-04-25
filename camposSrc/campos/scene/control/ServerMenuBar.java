package campos.scene.control;

import java.io.IOException;
import java.net.ServerSocket;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class ServerMenuBar extends MenuBar {
	public ServerMenuBar(ServerSocket server) {
		Menu menu = new Menu("File");
		MenuItem miExit = new MenuItem("Exit");
		miExit.setOnAction(e -> {
			try {
				System.out.println("Closing server...");
				server.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Platform.exit();
		});
		menu.getItems().addAll(miExit);
	}
}
