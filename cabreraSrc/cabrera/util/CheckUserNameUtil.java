package cabrera.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CheckUserNameUtil {

	public static ObservableList<String> filterList(ObservableList<String> temp, String input) {
		ObservableList<String> newList = FXCollections.observableArrayList();
		temp.forEach((String) -> {
			if (String.startsWith(input.toUpperCase(), 0)) {
				newList.add(String);
			}
		});
		return newList;
	}
}
