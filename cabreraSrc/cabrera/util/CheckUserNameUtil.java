package cabrera.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CheckUserNameUtil {

	public static ObservableList<String> filterList(ObservableList<String> temp, String input) {
		ObservableList<String> newList = FXCollections.observableArrayList();
		temp.forEach((String) -> {
			String testList = "";
			String testInput = "";
			if (input.length() <= String.length()) {
				testList = String.substring(0, input.length()).toUpperCase();
				testInput = input.toUpperCase();
			} else {
			testList = "";
			testInput = "";
			}
			if (!testList.equals("")  &&testInput.equals(testList)) {
				newList.add(String);
			}

		});
		return newList;
	}
}
