package campos.workbench.network;

import java.io.IOException;
import java.util.Scanner;

public class Demo {
	private static final String host = "25.4.225.164"; // Camposm's Laptop IP
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Who are you? ");
		try {
			User client = new User(input.nextLine(), host);
			System.out.println(client.getDis().readUTF());
			
			while (true) {
				System.out.println(client.getDis().readUTF());
				String answer = input.next();
				client.getDos().writeUTF(answer);
				if (!answer.equalsIgnoreCase("yes") || !answer.equalsIgnoreCase("no")) {
					break;
				}
				System.out.println(client.getDis().readUTF());
			}	
			input.close();
			client.getSocket().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
