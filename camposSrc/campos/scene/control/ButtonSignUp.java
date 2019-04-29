package campos.scene.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import campos.net.IPv4;
import campos.net.SocketType;
import campos.scene.layout.SignUpPane;
import campos.util.FXUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonSignUp extends Button {
	private SignUpPane signUpPane;
	
	public ButtonSignUp(SignUpPane signUpPane) {
		super("Sign Up");
		this.signUpPane = signUpPane;
		setPrefWidth(FXUtil.BT_WIDTH);
		setOnAction(new SignUpHandler());
	}
	
	private class SignUpHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			try {
				if (signUpPane.fieldsAreValid()) {
					Socket socket = new Socket(IPv4.HOST, IPv4.PORT);
					new Thread(new ClientHandler(socket)).start();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private class ClientHandler implements Runnable {
		private Socket socket;

		public ClientHandler(Socket socket) { // Constructor
			this.socket = socket;
		}
		
		@Override
		public synchronized void run() {
			try {
				attemptToSignUp();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public synchronized void attemptToSignUp() throws IOException, InterruptedException {
			System.out.println("Attempting to Sign Up...");
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(SocketType.SignUp);				
			oos.writeObject(signUpPane.getUserAccount());
			boolean flag = ois.readBoolean();
			System.out.println("Valid? " + flag);
			if (flag) {
				signUpPane.setValidUsername(flag);
			} else {
				signUpPane.setValidUsername(flag);
			}
			oos.close();
			ois.close();
			socket.close();
		}
	}
}
