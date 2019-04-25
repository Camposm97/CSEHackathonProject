package campos.stage;

import java.io.IOException;
import java.util.TreeSet;

import campos.io.DataLoader;
import campos.models.UserAccount;
import campos.scene.layout.ServerPane;
import campos.util.FXUtil;
import campos.util.ImgUtil;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerStage extends Stage {
	private TreeSet<UserAccount> userSet;	// Change to Tree, go faster O(log(N))
	private ServerPane root;
	
	public ServerStage(int port) throws IOException {
		this.userSet = DataLoader.loadUsers();
		this.root = new ServerPane(port);
		this.setScene(new Scene(root));
		this.setOnCloseRequest(new CloserServerHandler());
		this.setWidth(512);
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
