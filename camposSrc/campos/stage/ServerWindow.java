package campos.stage;

import java.io.IOException;

import campos.io.DataSaver;
import campos.scene.layout.ServerPane;
import campos.util.FXUtil;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerWindow extends Stage {
	private static final int WIDTH = 960;
	private static final int HEIGHT = 720;
	private ServerPane root;
	
	public ServerWindow(int port) throws IOException {
		root = new ServerPane(port);
		setScene(new Scene(root));
		setOnCloseRequest(new CloserServerHandler());
		setWidth(WIDTH);
		setHeight(HEIGHT);
		setTitle(FXUtil.TITLE);
	}
	
	private class CloserServerHandler implements EventHandler<WindowEvent> {
		@Override
		public void handle(WindowEvent event) {
			try {
				DataSaver.saveUserBag(root.getServer().getUserBag());
				root.getServer().close();
				System.out.println("Closing server...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
