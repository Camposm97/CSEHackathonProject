package campos.stage;

import java.io.IOException;

import campos.scene.layout.ServerPane;
import campos.util.FXUtil;
import campos.util.ImgUtil;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerWindow extends Stage {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private ServerPane root;
	
	public ServerWindow(int port) throws IOException {
		root = new ServerPane(port);
		setScene(new Scene(root));
		setOnCloseRequest(new CloserServerHandler());
		setWidth(WIDTH);
		setHeight(HEIGHT);
		setTitle(FXUtil.TITLE);
		ImgUtil.loadStageIcon(this);
	}
	
	private class CloserServerHandler implements EventHandler<WindowEvent> {
		@Override
		public void handle(WindowEvent event) {
			try {
				root.getServer().close();
				System.out.println("Closing server...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
