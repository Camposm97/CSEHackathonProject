package campos.scene.layout;

import java.io.IOException;
import java.net.ServerSocket;

import campos.io.DataLoader;
import campos.models.UserAccountBag;
import campos.scene.control.MyLabel;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ServerPane extends BorderPane {
	private UserAccountBag userBag;
	private ServerSocket server;
	private ConsolePane consolePane;
	
	public ServerPane(int port) throws IOException {
		this.userBag = DataLoader.loadUserBag();
		this.server = new ServerSocket(port);
		this.consolePane = new ConsolePane(server, userBag);
		this.setCenter(consolePane);
	}
	
	public ServerSocket getServer() {
		return server;
	}
}
