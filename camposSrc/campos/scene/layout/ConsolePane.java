package campos.scene.layout;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import campos.lang.VerifyLogin;
import campos.models.UserAccountBag;
import campos.util.FXUtil;
import javafx.scene.control.TextArea;

public class ConsolePane extends TextArea {
	private ServerSocket server;
	private UserAccountBag userBag;

	public ConsolePane(ServerSocket server, UserAccountBag userBag) {
		super("Server created on [" + new Date() + "]\nLoaded " + userBag.size() + "users\n");
		this.server = server;
		this.userBag = userBag;
		setWrapText(true);
		setEditable(false);
		setPadding(FXUtil.DEFAULT_INSETS);
		new Thread(new RunServer()).start();
	}
	
	public ServerSocket getServer() {
		return server;
	}
	
	public UserAccountBag getUserBag() {
		return userBag;
	}

	private class RunServer implements Runnable {
		@Override
		public void run() {
			try {
				appendText("Waiting for a connection...\n");
				while (true) {
					Socket socket = server.accept();
					appendText("Someone connected! " + socket.getLocalAddress());
					new Thread(new VerifyLogin(socket, userBag)).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
