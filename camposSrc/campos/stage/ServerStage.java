package campos.stage;

import java.io.IOException;

import campos.io.DataLoader;
import campos.models.UserAccountBag;
import campos.scene.layout.ServerPane;
import campos.util.FXUtil;
import campos.util.ImgUtil;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerStage extends Stage {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private UserAccountBag userBag;	
	private ServerPane root;
	
	public ServerStage(int port) throws IOException {
		this.userBag = DataLoader.loadUsers();
		this.root = new ServerPane(port);
		this.setScene(new Scene(root));
		this.setOnCloseRequest(new CloserServerHandler());
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		this.setTitle(FXUtil.TITLE);
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
