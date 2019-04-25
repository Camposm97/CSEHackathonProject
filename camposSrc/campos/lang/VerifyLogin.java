package campos.lang;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import campos.models.UserAccount;
import campos.models.UserAccountBag;

public class VerifyLogin implements Runnable {
	private Socket socket;
	private UserAccountBag userBag;
	
	public VerifyLogin(Socket socket, UserAccountBag userBag) {
		this.socket = socket;
		this.userBag = userBag;
	}
	
	@Override
	public void run() {
		ObjectInputStream ois;
		ObjectOutputStream oos;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			UserAccount temp = (UserAccount) ois.readObject();
			boolean flag = userBag.contains(temp);
			oos.writeBoolean(flag);
			ois.close();
			oos.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
