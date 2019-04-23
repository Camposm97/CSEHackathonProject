package cabrera.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CheckUserNameUtil {

	public static ObservableList<String> filterList(ObservableList<String> temp, String input) {
		ObservableList<String> newList = FXCollections.observableArrayList();
		temp.forEach((String) -> {
			String testList = null;
			String testInput = null;
			//boolean isNull = (testList == null && testInput == null);
			if (!(input.length() > String.length())) {
				testList = String.substring(0, input.length()).toUpperCase();
				testInput = input.toUpperCase();
			}
			System.out.println(testInput + " testInput");
			System.out.println(testList + " testList");
			if (testInput.equals(testList) && testList != null) {
				newList.add(String);
			}

		});
		return newList;
	}
}
