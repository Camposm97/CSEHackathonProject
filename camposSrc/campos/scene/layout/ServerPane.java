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
//		new ServerPaneUtil(this);
	}
	
	public ServerSocket getServer() {
		return server;
	}
	
//	private class ServerPaneUtil {
//		public ServerPaneUtil(ServerPane serverPane) {
//			loadConsolePane(serverPane);
//		}
//		
//		public void loadConsolePane(ServerPane serverPane) {
//			ta = new TextArea("Server created on [" + new Date() + "]\n");
//			ta.setFont(Font.font(20));
//			ta.setWrapText(true);
//			ta.setEditable(false);
//			StackPane pane = new StackPane(ta);
//			ta.prefWidthProperty().bind(pane.widthProperty().multiply(0.85));
//			pane.setPadding(FXUtil.DEFAULT_INSETS);
//			serverPane.setCenter(pane);
//		}
//	}
}
