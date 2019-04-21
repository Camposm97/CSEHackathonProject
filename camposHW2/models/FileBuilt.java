package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileBuilt {
	private ArrayList<String> contentList;				// O (1)
	
	public FileBuilt(String url) {	// O (n)
		try {
			readContentsUsingFile(new File(url));	// O (n)
		} catch (FileNotFoundException e) {e.printStackTrace();}
	}
	
	public FileBuilt(File file) {	// O (n)
		try {
			readContentsUsingFile(file);	// O (n)
		} catch (FileNotFoundException e) {e.printStackTrace();}
	}
	
	public ArrayList<String> getContentList() {	// O (1)
		return contentList;
	}
	
	public String[] getContent() {	// O (1 + 1  + 1) = O (3) = O (1)
		String[] content = new String[contentList.size()];	// O (1)
		content = contentList.toArray(content);				// O (1)
		return content;										// O (1)
	}
	
	public String getRandomToken() {	// O (1)
		return contentList.get((int)(Math.random() * (contentList.size() - 1)));
	}
	
	private void readContentsUsingFile(File file) throws FileNotFoundException {	// O (1 + 1 + n + 1 + 1) = O (4 + n) = O (n)
		contentList = new ArrayList<>();	// O (1)
		Scanner input = new Scanner(file);	// O (1)
		while (input.hasNext())				// O (n)
			contentList.add(input.nextLine());	// O (1)
		input.close(); 						// O (1)
	}
}
