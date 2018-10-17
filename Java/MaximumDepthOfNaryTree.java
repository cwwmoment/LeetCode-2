
/**
 * LeetCode #559. Maximum Depth of N-ary Tree
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */

public class MaximumDepthOfNaryTree {
	private int max = 0;
	public int maxDepth(Node root) {
		if (root == null) return 0;
		
		helper(root, 1);
		return max;
	}
	
	public void helper(Node root,int depth) {
		if (root == null) return;
		max = Math.max(max, depth);
		
		for (Node node : root.children) {
			helper(node, depth+1);
		}
	}
}
