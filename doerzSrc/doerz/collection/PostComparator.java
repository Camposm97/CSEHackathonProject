package doerz.collection;

import java.util.Comparator;

import doerz.model.Post;

public class PostComparator implements Comparator<Post>{

	@Override
	public int compare(Post p1, Post p2) {
		return p1.compareTo(p2);
	}

}
