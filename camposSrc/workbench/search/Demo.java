package workbench.search;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
	private static final Scanner input = new Scanner(System.in);
	private static final ArrayList<String> list = fillArrayList();
	
	public static void main(String[] args) {
		startProgram();
	}

	public static void startProgram() {
		while (true) {
			String key = askForKey();
			if (!key.equals("exit"))
				searchForUsernames(list, key);
			else
				break;
		}
		input.close();
	}

	public static String askForKey() {
		System.out.print("Please enter a username to search for: ");
		String key = input.nextLine();
		return key;
	}

	public static void searchForUsernames(ArrayList<String> list, String key) {
		for (String word : list) {
			if (word.contains(key)) {
				/**
				 * So IF the key can be "seen" in the word then print it out. Like how you have
				 * the word "Canada", it contains the word "Can" (case sensitive)
				 */
				System.out.println(word);
			}
		}
		System.out.println();
		/**
		 * Notes: Perhaps when the searching for usernames, we make them all uppercase
		 * and make the key (input from user) to uppercase to avoid case sensitivity.
		 */
	}

	public static ArrayList<String> fillArrayList() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Camposm98");
		list.add("Camposm97");
		list.add("Camposm");
		list.add("Camposm01");
		list.add("Campus");
		list.add("Campusm");
		list.add("Camposm19");
		list.add("Camp");
		list.add("Composm");
		list.add("Compost");
		list.add("Camposm21");
		list.add("Camposm28");
		list.add("Composm13");
		list.add("Campasta");
		list.add("Camposter");
		list.add("Camera91");
		list.add("Camus25");
		list.add("Campues25");
		return list;
	}
}
