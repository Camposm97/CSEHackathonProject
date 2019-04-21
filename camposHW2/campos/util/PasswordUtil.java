package campos.util;

public class PasswordUtil {
	public static boolean isValid(String string) {
		return (hasEightCharacters(string) && hasUpperCase(string) && hasLowerCase(string) && hasSymbol(string));
	}
	
	public static boolean hasEightCharacters(String string) {
		return string.length() >= 8;
	}
	
	public static boolean hasUpperCase(String string) {
		for (char c : string.toCharArray())
			if (c >= 'A' && c <= 'Z')
				return true;
		return false;
	}
	
	public static boolean hasLowerCase(String string) {
		for (char c : string.toCharArray())
			if (c >= 'a' && c <= 'z')
				return true;
		return false;
	}
	
	public static boolean hasSymbol(String string) {
//		for (char c : string.toCharArray())
//			if ((c >= ' ' && c <= '/') || (c >= ':' && c <= '`') || (c >= '{' && c <= '~'))
//				return true;
		String regex = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		for (char c : string.toCharArray())
			for (char d : regex.toCharArray())
				if (d == c)
					return true;
		return false;
	}
}
