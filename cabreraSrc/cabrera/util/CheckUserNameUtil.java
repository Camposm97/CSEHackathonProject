package cabrera.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class CheckUserNameUtil {

	public static void check(ListView<String> users, String input) {
		ObservableList<String> newList = FXCollections.observableArrayList();
		users.getItems().forEach((String) -> {
			String testList = "";
			String testInput = "";
			if (input.length() <= String.length()) {
				testList = String.substring(0, input.length()).toUpperCase();
				testInput = input.toUpperCase();
			} else {
			testList = "";
			testInput = "";
			}
			if (!testList.equals("")  && testInput.equals(testList)) {
				newList.add(String);
			}
		});
		users.setItems(newList);
	}
}
