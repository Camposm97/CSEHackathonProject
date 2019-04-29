package util;

import campos.models.Gender;
import campos.models.Major;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.util.Random;

/*
 * The methods in this class are used to generate dummy objects for testing purposes
 */

public class Dummy {
	// Creates dummy user account to tie into post creation (posts must be made by a user account)
	public static UserAccount getDummyAcc(String username) {
		Name dummyName = new Name("John", "Doe", Gender.Male);
		Student dummyStudent = new Student(dummyName, Major.CSE);
		String password = getRandomPass();
		
		UserAccount dummyAcc = new UserAccount(dummyStudent, username, password);
		System.out.println(dummyAcc.toString());
		return dummyAcc;
	}
	
	// Not sure what this method was intended for. Will delete when sure it isn't in use.
	public static UserAccount setAcc(String first, String last, String user, String pass) {
		
		
		return null;
	}
	
	public static String getRandomPass() {
		return Random.getPassword();
	}
	
}
