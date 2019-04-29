package campos.scene.layout;

import java.net.Socket;
import java.util.Date;

import campos.net.MyServerSocket;
import campos.net.ServerHandler;
import campos.util.FXUtil;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class ConsolePane extends TextArea {
	private MyServerSocket server;

	public ConsolePane(MyServerSocket server) {
		super("Server created on [" + new Date() + "] - [Host: " + server.getInetAddress().getHostAddress()
				+ " | Port: " + server.getLocalPort() + "]\n" + server.getUserBag().toString() + "\n");
		this.setFont(Font.font("Consolas", 16));
		this.server = server;
		this.setWrapText(true);
		this.setEditable(false);
		this.setPadding(FXUtil.DEFAULT_INSETS);
		new Thread(new RunServer(this)).start();
	}

	public MyServerSocket getServer() {
		return server;
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
				try {
					while (true) {
						Socket socket = server.accept();
						new Thread(new ServerHandler(socket, ta)).start();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
