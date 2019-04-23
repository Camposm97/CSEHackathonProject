package util;

import campos.models.Major;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.util.Gender;
import campos.util.Random;
import doerz.model.Post;

/*
 * The methods in this class are used to generate dummy objects for testing purposes
 */

public class Dummy {
	private static int c = 5;  	// 'c'ounter shows username uniqueness
	
	// Makes generic post to evaluate feed functionality
	public static Post makeDummyPost() {								
		UserAccount dummyAcc = getDummyAcc();
		String testMsg = "The quick brown fox jumps over the lazy dog.\n 1234567890 \n!@#$%^&*()_+-=`~{}[]\\|;:',<.>/?\"\n\nlinebreak\n\n\ttab";
		Post dummyPost = new Post(testMsg, dummyAcc);
		return dummyPost;
	}
	
	// Creates dummy user account to tie into post creation (posts must be made by a user account)
	public static UserAccount getDummyAcc() {
		Name dummyName = new Name("John", "Doe", Gender.Male);
		Student dummyStudent = new Student(dummyName, Major.CSE);
		String password = Random.getPassword();
		
		UserAccount dummyAcc = new UserAccount(dummyStudent, "username" + c++, password);
		System.out.println(dummyAcc.toString());
		return dummyAcc;
	}
	
}
