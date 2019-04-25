package campos.scene.layout;

import java.io.IOException;
import java.net.ServerSocket;

import javafx.scene.layout.BorderPane;

public class ServerPane extends BorderPane {
	private ServerSocket server;
	private ConsolePane consolePane;
//	private TextArea ta;
	
	public ServerPane(int port) throws IOException {
		this.server = new ServerSocket(port);
		this.consolePane = new ConsolePane(server);
		this.setCenter(consolePane);
	}
	
	public ServerSocket getServer() {
		return server;
	}
}
