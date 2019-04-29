package cabrera.models;

public class Log {
	String log;
	String userName;
	
	public Log(String userName) {
		this.userName = userName;
		this.log = userName + "'s log\n";
	}
	public void addToLog(String message) {
		this.log += message;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
