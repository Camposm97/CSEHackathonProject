package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Server extends Application {

	private static int clientNo = 0;
	private String message;

	// ENTER PORT HERE:
	private static int port = 7000;

	public static void main(String[] args) {
		launch(args);
	}

	class HandleAClient implements Runnable {
		private Socket socket;

		public HandleAClient(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

				outputToClient.writeUTF("Connected\nYou are Client" + clientNo + "\n---");
				// Continuously serve the client
				while (true) {
					// Receive message from the client
					// if(message != null) {
					// message += "\nClient" + clientNo + ":\t" + inputFromClient.readUTF();
					// } else {
						message = "Client" + clientNo + ":\t" + inputFromClient.readUTF();
					// }

					Platform.runLater(() -> {
						System.out.println(message);
					});

					outputToClient.writeUTF(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {

		new Thread(() -> {
			try {
				ServerSocket serverSocket = new ServerSocket(port);
				System.out.println("MultiThreadServer started at " + new Date() + '\n');

				while (true) {
					Socket socket = serverSocket.accept();

					clientNo++;

					Platform.runLater(() -> {
						System.out.println("Starting thread for client " + clientNo + " at " + new Date() + '\n');
						InetAddress inetAddress = socket.getInetAddress();
						System.out
								.println("Client " + clientNo + "'s host name is " + inetAddress.getHostName() + "\n");
						System.out.println(
								"Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + "\n");
					});

					new Thread(new HandleAClient(socket)).start();
				}
				// serverSocket.close();
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}).start();
	}

}
