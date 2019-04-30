package workbench.search;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		ArrayList<String> list = fillArrayList();
		final String key = "C";	// From search textfield
		
		for (String word : list) {
			if (word.contains(key)) {
				/**
				 * So IF the key can be "seen" in the word
				 * then print it out.  Like how you have the word
				 * "Canada", it contains the word "Can" (case sensitive)
				 */
				System.out.println(word);
			}
		}
		/**
		 * Notes:
		 * Perhaps when the searching for usernames, we make them all uppercase and make
		 * the key (input from user) to uppercase to avoid case sensitivity.  
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
