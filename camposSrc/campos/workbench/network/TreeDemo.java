package campos.workbench.network;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeDemo {
	public static void main(String[] args) {
		TreeSet<String> tree = new TreeSet<>();
		tree.add("Hello");
		tree.add("World");
		tree.add("!");
		System.out.println(tree);
		tree.remove("Hello");
		System.out.println(tree);
		String[] arr = new String[tree.size()];
		arr = tree.toArray(arr);
		System.out.println("Array: " + Arrays.toString(arr));
	}
}
