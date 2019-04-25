package campos.scene.layout;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import campos.models.UserAccount;
import campos.models.UserAccountBag;
import campos.util.FXUtil;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ConsolePane extends TextArea {
	private ServerSocket server;
	private UserAccountBag userBag;

	public ConsolePane(ServerSocket server, UserAccountBag userBag) {
		super("Server created on [" + new Date() + "]\nLoaded " + userBag.size() + " users\n");
		this.server = server;
		this.userBag = userBag;
		setWrapText(true);
		setEditable(false);
		setPadding(FXUtil.DEFAULT_INSETS);
		new Thread(new RunServer(this)).start();
	}

	public ServerSocket getServer() {
		return server;
	}

	public UserAccountBag getUserBag() {
		return userBag;
	}

	private class RunServer implements Runnable {
		private ConsolePane ta;

		public RunServer(ConsolePane ta) {
			this.ta = ta;
		}

		@Override
		public void run() {
			appendText("Waiting for a connection...\n");
			new Thread(() -> {
				int id = 0;
				try {
					while (true) {
						Socket socket = server.accept();
						InetAddress inet = socket.getInetAddress();
						appendText("Connection [");
						appendText("Host: " + inet.getHostName() + " | ");
						appendText("IP: " + inet.getHostAddress() + "]\n");
						new Thread(new VerifyLogin(socket, ta)).start();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}

	private class VerifyLogin implements Runnable {
		private Socket socket;
		private ConsolePane ta;

		public VerifyLogin(Socket socket, ConsolePane ta) {
			this.socket = socket;
			this.ta = ta;
		}

		@Override
		public void run() {
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				UserAccount temp = (UserAccount) ois.readObject();
				boolean exists = ta.getUserBag().contains(temp);
				Platform.runLater(() -> {
					ta.appendText("Does " + temp.getUsername() + " exist? " + exists + "\n");
					ta.appendText("\n");
				});
				oos.close();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
