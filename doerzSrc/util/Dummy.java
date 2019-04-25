package util;

import campos.models.Gender;
import campos.models.Major;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.util.Random;
import doerz.model.Post;

/*
 * The methods in this class are used to generate dummy objects for testing purposes
 */

public class Dummy {
//	private static int c = 5;  	// 'c'ounter shows username uniqueness
	
	// Makes generic post to evaluate feed functionality
	public static Post makeDummyPost() {								
		UserAccount dummyAcc = getDummyAcc("defaultUser");
		String testMsg = "The quick brown fox jumps over the lazy dog.\n 1234567890 \n!@#$%^&*()_+-=`~{}[]\\|;:',<.>/?\"\n\nlinebreak\n\n\ttab";
		Post dummyPost = new Post(testMsg, dummyAcc);
		return dummyPost;
	}
	
	// Creates dummy user account to tie into post creation (posts must be made by a user account)
	public static UserAccount getDummyAcc(String username) {
		Name dummyName = new Name("John", "Doe", Gender.Male);
		Student dummyStudent = new Student(dummyName, Major.CSE);
		String password = getRandomPass();
		
		UserAccount dummyAcc = new UserAccount(dummyStudent, username, password);
		System.out.println(dummyAcc.toString());
		return dummyAcc;
	}
	
	public static UserAccount setAcc(String first, String last, String user, String pass) {
		
		
		return null;
	}
	
	public static String getRandomPass() {
		return Random.getPassword();
	}
	
}
