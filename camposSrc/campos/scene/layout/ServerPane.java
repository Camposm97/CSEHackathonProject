package campos.scene.layout;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

import campos.scene.control.ServerMenuBar;
import campos.util.FXUtil;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class ServerPane extends BorderPane {
	private ServerSocket server;
	private ServerMenuBar menuBar;
	private TextArea ta;
	
	public ServerPane(int port) throws IOException {
		this.server = new ServerSocket(port);
		this.menuBar = new ServerMenuBar(server);
		this.setTop(menuBar);
		new ServerPaneUtil(this);
	}
	
	public ServerSocket getServer() {
		return server;
	}
	
	public class ServerPaneUtil {
		public ServerPaneUtil(ServerPane serverPane) {
			loadConsolePane(serverPane);
		}
		
		public void loadConsolePane(ServerPane serverPane) {
			ta = new TextArea("Server created on [" + new Date() + "]");
			ta.setWrapText(true);
			ta.setEditable(false);
			StackPane pane = new StackPane(ta);
			ta.prefWidthProperty().bind(pane.widthProperty().multiply(0.85));
			pane.setPadding(FXUtil.DEFAULT_INSETS);
			serverPane.setCenter(pane);
		}
	}
}
