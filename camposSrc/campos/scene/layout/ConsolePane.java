package campos.scene.layout;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import campos.models.UserAccountBag;
import campos.util.FXUtil;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

public class ConsolePane extends StackPane {
	private ServerSocket server;
	private UserAccountBag userBag;
	private TextArea ta;
	
	public ConsolePane(ServerSocket server, UserAccountBag userBag) {
		this.server = server;
		this.userBag = userBag;
		this.ta = loadTa();
		this.setPadding(FXUtil.DEFAULT_INSETS);
		this.getChildren().add(ta);
		new Thread(new RunServer()).start();
	}
	
	private TextArea loadTa() {
		TextArea ta = new TextArea("Server created on [" + new Date() + "]\nLoaded " + userBag.size() + " users\n");
		ta.setWrapText(true);
		ta.setEditable(false);
		return ta;
	}
	
	private class RunServer implements Runnable {
		@Override
		public void run() {
			try {
				Platform.runLater(new AppendTa("Waiting for a connection...\n"));
				while (true) {
					Socket socket = server.accept();
					Platform.runLater(new AppendTa("Someone connected!\n"));
					new Thread(new HandleClient(socket));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class HandleClient implements Runnable {
		private Socket socket;
		
		public HandleClient(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(socket.getInputStream());
				
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class AppendTa implements Runnable {
		private String string;
		
		public AppendTa(String string) {
			this.string = string;
		}
		@Override
		public void run() {
			ta.appendText(string);
		}
	}
}	
