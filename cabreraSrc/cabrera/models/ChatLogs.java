package cabrera.models;

public class ChatLogs {
	Log[] logs;
	int nElems;
	
	public ChatLogs(int maxSize) {
		logs = new Log[maxSize];
		nElems = 0;
		//Needs to be added as people come online
		addLog("EJ");
		addLog("Michael");
		addLog("Richard");
	}
	public void addLog(String userName) {
		logs[nElems++] = new Log(userName);
	}
	public Log findLog(String currentFriend) {
		for(int i = 0; i < nElems; i++) {
			if(logs[i].getUserName().equals(currentFriend)) {
				return logs[i];
			}
		}
		System.out.println("Not Found");
		return null;
	}
	public void addToLog(String message, String currentFriend) {
		findLog(currentFriend).addToLog(message);
	}
}
