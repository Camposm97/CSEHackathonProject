package campos.app.login;

import java.util.TreeSet;

import campos.io.DataLoader;
import campos.models.Gender;
import campos.models.Major;
import campos.models.Name;
import campos.models.Student;
import campos.models.UserAccount;
import campos.stage.LoginStage;
import javafx.application.Application;
import javafx.stage.Stage;


public class Demo extends Application {	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new LoginStage();
		stage.show();
	}
	
	public static void main(String[] args) {
//		launch(args);
		TreeSet<UserAccount> userTree = DataLoader.loadUsers();
		for (UserAccount u : userTree)
			System.out.println(u);
		UserAccount temp = new UserAccount(new Student(null, null), "CamaO2", "nS-XTO/u");
		UserAccount user = new UserAccount(new Student(new Name("Campos", "Michael", Gender.Male), Major.CSE), "Camposm", "1234");
		System.out.println(userTree.contains(temp));
	}
}
