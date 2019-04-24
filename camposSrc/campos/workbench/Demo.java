package campos.workbench;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Demo {
	private static final String host = "25.5.191.107"; // Camposm's Laptop IP
	
	public static void main(String[] args) {
		String username = askForUsername();
		try {
			Client client = new Client(username, host);
			System.out.println("Succesfully connected to " + client.getSocket().getInetAddress().getHostAddress());
			System.out.println("Start chatting!");
			
			while (true) {
				String message = chat();
				if (message.equals("stop")) {
					client.send(client.getUsername() + " left");
					break;
				}
				client.send(client.getUsername() + ": " + message);
			}	
			client.getSocket().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String chat() throws IOException {
		Scanner in = new Scanner(System.in);
		String message = null;
		try {
			System.out.print("You: ");
			message = in.nextLine();
		} catch (NoSuchElementException e) {
			return "Error...";
		}
		finally {
			in.close();
		}
		return message;
	}
	
	public static String askForUsername() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String username = in.nextLine();
		in.close();
		return username;
	}
}
