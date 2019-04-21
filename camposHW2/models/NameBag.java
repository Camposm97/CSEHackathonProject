package models;

public class NameBag {
	private Name[] names;
	private int nElems;
	private int size;
	
	public NameBag(int size) {
		names = new Name[size];
		nElems = 0;
		this.size = size;
	}
	
	public Name get(int i) {
		return names[i];
	}
	
	public void insert(String last, String first, String gender) {
		names[nElems++] = new Name(last, first, gender);
		checkBounds();
	}
	
	public int size() {
		return size;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++)
			System.out.println(names[i].toString());
	}
	
	private void checkBounds() {
		if (nElems > names.length - 1) {
			Name[] temp = new Name[names.length * 2];

			for (int i = 0; i < names.length; i++)
				temp[i] = names[i];
			names = temp;
		}
	}
}
