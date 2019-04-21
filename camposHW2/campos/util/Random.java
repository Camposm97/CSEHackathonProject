package campos.util;

import campos.models.FileBuilt;

public class Random {	
	public static double getGpa() {
		final double GPA = 4.0;
		return (Math.random() * GPA) + 1;
	}
	
	public static String getPassword() {
		final int length = 8;
		String str = "";
		do { str = getChars(length);
		} while (!PasswordUtil.isValid(str));
		return str;
	}
	
	public static String getChars(int n) {
		String alphabet = "AaBcCcDdEeFfGgHhIiJjKkMmNnOoPpQqRrSsTtUuVvWwXxYyZz !\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~";
		String str = "";
		for (int i = 0; i < n; i++)
			str += alphabet.charAt(getNumber(alphabet.length(), 0));
		return str;
	}
	
	public static int getNumber(int max, int min) {
		return (int) ((Math.random() * max) + min);
	}
}
