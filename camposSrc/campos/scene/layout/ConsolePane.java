package campos.scene.layout;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import campos.lang.VerifyLogin;
import campos.models.UserAccountBag;
import campos.util.FXUtil;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

public class ConsolePane extends TextArea {
	private ServerSocket server;
	private UserAccountBag userBag;

	public ConsolePane(ServerSocket server, UserAccountBag userBag) {
		super("Server created on [" + new Date() + "]\nLoaded " + userBag.size() + "users\n");
		setWrapText(true);
		setEditable(false);
		this.server = server;
		this.userBag = userBag;
		this.setPadding(FXUtil.DEFAULT_INSETS);
		new Thread(new RunServer()).start();
	}

	private class RunServer implements Runnable {
		@Override
		public void run() {
			try {
				Platform.runLater(new AppendTa("Waiting for a connection...\n"));
				while (true) {
					Socket socket = server.accept();
					Platform.runLater(new AppendTa("Someone connected!\n"));
					new Thread(new VerifyLogin(socket, userBag)).start();
				}
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
