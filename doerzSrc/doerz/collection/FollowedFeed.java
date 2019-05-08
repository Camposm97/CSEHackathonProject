package doerz.collection;

import java.util.LinkedList;

import campos.models.UserAccount;
import doerz.model.Post;

public class FollowedFeed {
	
	public static LinkedList<Post> getFeedPosts(UserAccount user){
		LinkedList<Post> followedPosts = new LinkedList<>();
		PostComparator comp = new PostComparator();
		
		followedPosts.addAll(user.getPostList());
		for (UserAccount u : user.getUserFollowBag()) {
			followedPosts.addAll(u.getPostList());
		}
		followedPosts.sort(comp);
		return followedPosts;
	}
}
