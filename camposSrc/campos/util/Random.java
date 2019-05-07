package campos.util;

import campos.models.Major;
import javafx.scene.image.Image;

public class Random {
	public static double emitGpa() {
		final double GPA = 4.0;
		return (Math.random() * GPA) + 1;
	}

	public static String emitPassword() {
		final int length = 8;
		String str = "";
		do {
			str = emitCharacters(length);
		} while (!PasswordUtil.isValid(str));
		return str;
	}

	public static String emitCharacters(int n) {
//		String alphabet = "AaBcCcDdEeFfGgHhIiJjKkMmNnOoPpQqRrSsTtUuVvWwXxYyZz !\"#$%&'()*+,-./:;<=>?@[]^_`{|}~";
		String alphabet = "AaBcCcDdEeFfGgHhIiJjKkMmNnOoPpQqRrSsTtUuVvWwXxYyZz~!@#$%^&*()-_=+";
		String str = "";
		for (int i = 0; i < n; i++)
			str += alphabet.charAt(emitNumber(alphabet.length(), 0));
		return str;
	}

	public static int emitNumber(int max, int min) {
		return (int) ((Math.random() * max) + min);
	}

	public static Major emitMajor() {
		return Major.values()[(int) (Math.random() * Major.values().length)];
	}
	
	public static String emitAvatarUrl() {
		int n = emitNumber(ImgUtil.NUM_OF_AVATARS, 0);
		String url = "resources/images/avatar/" + String.valueOf(n) + ".jpg";
		return url;
	}
	
	public static Image emitAvatar() {
		int n = emitNumber(ImgUtil.NUM_OF_AVATARS, 0);
		Image image = ImgUtil.loadImg("resources/images/avatars/" + String.valueOf(n) + ".jpg");
		return image;
	}
}
