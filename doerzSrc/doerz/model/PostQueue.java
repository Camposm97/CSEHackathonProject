package doerz.model;

/*
 * depreciated - Will remove when I'm sure I don't need it anymore.
 */

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
	
	public Post[] toArray() {
		return postQ.toArray();
	}
	
	public void reset() {
		postQ.reset();
	}
}
