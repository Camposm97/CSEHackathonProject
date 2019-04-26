package campos.scene.layout;

import java.io.IOException;
import java.net.ServerSocket;

import campos.net.MyServerSocket;
import javafx.scene.layout.BorderPane;

public class ServerPane extends BorderPane {
	private MyServerSocket server;
	private ConsolePane consolePane;
	
	public ServerPane(int port) throws IOException {
		this.server = new MyServerSocket(port);
		this.consolePane = new ConsolePane(server);
		this.setCenter(consolePane);
	}
	
	public ServerSocket getServer() {
		return server;
	}
}
