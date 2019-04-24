package campos.stage;

import java.io.IOException;

import campos.io.DataLoader;
import campos.models.UserAccountBag;
import campos.scene.layout.ServerPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerStage extends Stage {
	private UserAccountBag userBag;	// Change to Tree, go faster O(log(N))
	private ServerPane root;
	
	public ServerStage(int port) throws IOException {
		this.userBag = DataLoader.loadUsers();
		this.root = new ServerPane(port);
		this.setScene(new Scene(root));
		this.setOnCloseRequest(e -> {
			try {
				System.out.println("Closing server...");
				root.getServer().close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	public UserAccountBag getUserBag() {
		return userBag;
	}
}
