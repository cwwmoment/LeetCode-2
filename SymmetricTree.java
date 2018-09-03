
/**
 * LeetCode #101. Symmetric Tree
 * 
 * Created by happygirlzt on 3 Sep 2018 at 11:01:18 AM
 *
 */

import java.util.List;
import java.util.ArrayList;

public class SymmetricTree {
	// fix the bug but it is a silly solution
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		if ((root.left != null && root.right != null ) && (root.left.val != root.right.val)) return false;
		List<Integer> list = new ArrayList<>();
		int[] l = new int[1];
		int[] r = new int[1];
		inOrder(list, root, l, r);
		
		if (l[0] != r[0]) return false;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != list.get(list.size() - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public void inOrder(List<Integer> list, TreeNode root, int[] l, int[] r) {
		if (root == null) return;
		
		if (root.left != null) {
			l[0]++;
			inOrder(list, root.left, l, r);
		}
		
		list.add(root.val);
		
		if (root.right != null) {
			r[0]++;
			inOrder(list, root.right, l, r);
		}
	}
	
	// others' smart solution
	public boolean isSymmetric1(TreeNode root) {
		return dfs(root, root);
	}
	
	public boolean dfs(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val == right.val) {
			return dfs(left.right, right.left) && dfs(left.left, right.right);
		}
		
		return false;
	}
	
}