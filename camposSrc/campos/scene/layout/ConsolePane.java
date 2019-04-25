package campos.scene.layout;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import campos.util.FXUtil;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

public class ConsolePane extends StackPane {
	private ServerSocket server;
	private TextArea ta;
	
	public ConsolePane(ServerSocket server) {
		this.server = server;
		this.ta = new TextArea();
		this.setPadding(FXUtil.DEFAULT_INSETS);
		new Thread(new RunServer()).start();
	}
	
	private class RunServer implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					Socket socket = server.accept();
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					Platform.runLater(() -> {
						ta.appendText("");
					});
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}	
