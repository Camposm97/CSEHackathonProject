package campos.models;

public class UserAccountBag {
	private UserAccount[] users;
	private int nElems;
	
	public UserAccountBag(int size) {
		users = new UserAccount[size];
		nElems = 0;
	}
	
	public UserAccount get(int i) {
		return users[i];
	}
	
	public void insert(UserAccount user) {
		users[nElems++] = user;
		checkBounds();
	}
	
	public UserAccount findByUsername(String username) {
		int first = 0, last = nElems, middle, result;
		
		while (first <= last) {
			middle = (first + last) / 2;
			result = username.compareTo(users[middle].getUsername());
			
			if (result == 0)
				return users[middle];
			
			if (result > 0)
				first = middle + 1;
			else
				last = middle - 1;
		}
		return null;	// User Not Found
	}
		
	public void sortByUsername() {
		int in;
		int out;
		for (out = 1; out < nElems; out++) {
			UserAccount temp = users[out];
			in = out;
			
			while (in > 0 && users[in - 1].getUsername().compareTo(temp.getUsername()) > 0) {
				users[in] = users[in - 1];
				in--;
			}
			users[in] = temp;
		}
	}
	
	public void sortByPassword() {
		int in;
		int out;
		for (out = 1; out < nElems; out++) {
			UserAccount temp = users[out];
			in = out;
			
			while (in > 0 && users[in - 1].getPassword().compareTo(temp.getPassword()) > 0) {
				users[in] = users[in - 1];
				in--;
			}
			users[in] = temp;
		}
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(users[i].toString());
		}
	}
	
	public String[] getUsers() {
		String[] array = new String[nElems];
		for (int i = 0; i < nElems; i++)
			array[i] = users[i].getUsername();
		return array;
	}
	
	private void checkBounds() {
		if (nElems > users.length - 1) {
			UserAccount[] temp = new UserAccount[users.length * 2];

			for (int i = 0; i < users.length; i++)
				temp[i] = users[i];
			users = temp;
		}
	}
}
