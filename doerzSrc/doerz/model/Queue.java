package doerz.model;


public class Queue {
	private int maxSize;
	private Post[] queArray;
	private int head;
	private int tail;
	private int nElems;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		queArray = new Post[maxSize];
		head = 0;
		tail = -1;
		nElems = 0;
	}
	
	public void insert(Post p) {
		if(tail == maxSize - 1) {
			tail = -1;
		}
		queArray[++tail] = p;
		if(nElems != maxSize) {
			nElems++;
		}
	}
	
	public Post peek() {
		return queArray[head];
	}
	
	public boolean isEmpty() {
		return nElems == 0;
	}
	
	public boolean isFull() {
		return nElems == maxSize;
	}
	
	public int size() {
		return nElems;
	}
	
	public int locateHead() {
		return head;
	}
	
	public int locateTail() {
		return tail;
	}
	
	public Post remove() {
		Post temp = queArray[head++];
		if(head == maxSize) {
			head = 0;
		}
		nElems--;
		return temp;
	}
	
	public Post display(int index) {
		return queArray[index];
	}
	
	public Post[] toArray() {
		Post[] arr = new Post[nElems];
		int start = tail+1;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = queArray[start++];
			if (start == arr.length) {
				start = 0;
			}
		}
		return arr;
	}
	
	public void reset() {
		int size = queArray.length;
		queArray = new Post[size];
		head = 0;
		tail = -1;
		nElems = 0;
	}
}
