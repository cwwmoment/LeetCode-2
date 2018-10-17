/**
 * LeetCode # 95. Unique Binary Search Trees II
 * 
 * Created on 2018-08-26
 * 
 * @author happygirlzt
 *
 */
import java.util.ArrayList;

public class UniqueBinarySearchTree2 {
	/**
	 * 以i为根节点的树，其左子树由[1, i-1]构成， 其右子树由[i+1, n]构成。
	 * @param n
	 * @return
	 */
	public ArrayList<TreeNode> generateTrees(int n) {
		if (n == 0) {
	        return new ArrayList<TreeNode>();
	    }
		
		return helper(1, n);
	}
	
	public ArrayList<TreeNode> helper(int left, int right) {
		ArrayList<TreeNode> res = new ArrayList<>();
		
		// base case
		if (left > right) {
			res.add(null);
			return res;
		}
		
		for (int i = left; i <= right; i++) {
			ArrayList<TreeNode> lefts = helper(left, i - 1);
			ArrayList<TreeNode> rights = helper(i + 1, right);
			
			for (int j = 0; j < lefts.size(); j++) {
				for (int k = 0; k < rights.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = lefts.get(j);
					root.right = rights.get(k);
					
					res.add(root);
				}
			}
		}
		
		return res;
	}
}
