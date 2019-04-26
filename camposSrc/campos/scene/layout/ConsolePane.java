package campos.scene.layout;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

import campos.net.HandleClient;
import campos.net.MyServerSocket;
import campos.util.FXUtil;
import javafx.scene.control.TextArea;

public class ConsolePane extends TextArea {
	private MyServerSocket server;

	public ConsolePane(MyServerSocket server) {
		super("Server created on [" + new Date() + "]\nDetails [IP: " + server.getInetAddress().getHostAddress() + " | Port: "
				+ server.getLocalPort() + "]\n");
		this.server = server;
		setWrapText(true);
		setEditable(false);
		setPadding(FXUtil.DEFAULT_INSETS);
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
						new Thread(new HandleClient(socket, ta)).start();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
