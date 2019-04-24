package campos.workbench;

import java.io.IOException;
import java.util.Scanner;

public class Demo {
	private static final String host = "localhost"; // Camposm's Laptop IP
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Who are you? ");
		try {
			Client client = new Client(input.nextLine(), host);
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
