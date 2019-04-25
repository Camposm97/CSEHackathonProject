package campos.util;

import campos.models.UserAccount;

public class BinarySearch {
	public static int binarySearch(UserAccount[] arr, String username, int first, int last) {
//		System.out.println(first + " " + last);
		if (first < last) {
			int middle = (first + last) / 2;
			int result = username.compareTo(arr[middle].getUsername());
			if (result == 0) {
				return middle;
			} else if (result > 0) {
				return binarySearch(arr, username, middle + 1, last);
			} else {
				return binarySearch(arr, username, first, middle - 1);
			}
		} 
		return -1;
	}
}
