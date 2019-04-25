package campos.stage;

import java.io.IOException;

import campos.io.DataLoader;
import campos.models.UserAccountBag;
import campos.scene.layout.ServerPane;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerStage extends Stage {
	private UserAccountBag userBag;	// Change to Tree, go faster O(log(N))
	private ServerPane root;
	
	public ServerStage(int port) throws IOException {
		this.userBag = DataLoader.loadUsers();
		this.root = new ServerPane(port);
		this.setScene(new Scene(root));
		this.setOnCloseRequest(new ServerCloseHandler());
		this.setWidth(512);
	}
	
	public UserAccountBag getUserBag() {
		return userBag;
	}
	
	private class ServerCloseHandler implements EventHandler<WindowEvent> {

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
