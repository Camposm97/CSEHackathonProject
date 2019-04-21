package utilities;

import models.Name;
import models.Student;
import models.UserAccount;
import view.SignUpPane;

public class SignUpUtil {
	public static boolean fieldsAreValid(SignUpPane pane) {
		return !pane.getTfFirstName().getText().isEmpty() && 
				!pane.getTfLastName().getText().isEmpty() && 
				!pane.getTfGender().getText().isEmpty() && 
				!pane.getTfGpa().getText().isEmpty() && 
				!pane.getTfUsername().getText().isEmpty();
	}
	
	public static void addUserToBag(SignUpPane signUpPane) {
		String lastName = signUpPane.getTfLastName().getText();
		String firstName = signUpPane.getTfFirstName().getText();
		String gender = signUpPane.getTfGender().getText();
		
		String username = signUpPane.getTfUsername().getText();
		String password = signUpPane.getTfPass().getText();
		double gpa = Double.parseDouble(signUpPane.getTfGpa().getText());
		
		Student student = new Student(new Name(lastName, firstName, gender), gpa);
		signUpPane.getUserAccountBag().insert(new UserAccount(student, username, password));
		signUpPane.getUserAccountBag().sortByUsername();
		System.out.println();
		signUpPane.getUserAccountBag().display();
		FXLoader.switchToLoginPane(signUpPane);
	}
}
