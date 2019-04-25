package doerz.model;


public class PostQueue {
	private Queue postQ;
	
	public PostQueue(int size) {
		super();
		this.postQ = new Queue(size);
	}

	public void add(Post p) {
		postQ.insert(p);
	}
	
	public void delete() {
		postQ.remove();
	}
	
	public Post peek() {
		return postQ.peek();
	}
	
	public Post display(int index) {
		return postQ.display(index);
	}
	
}
