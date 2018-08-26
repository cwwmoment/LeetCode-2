/**
 * LeetCode 872. Leaf-Similar Trees
 * 
 * Created on 2018-08-26
 * 
 * @author happygirlzt
 *
 */
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class LeafSimilarTrees {
	/**
	 * 敲开心！虽然这题超简单。。但是很快就能一下子写出来dfs的题目，很开心！
	 * 继续加油！
	 * @param root1
	 * @param root2
	 * @return
	 */
	
	// Recursive
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		
		helper(root1, l1);
		helper(root2, l2);
		return l1.equals(l2);
	}
	
	public void helper(TreeNode root, List<Integer> list) {
		if (root == null) return;
		
		if (root.left != null) {
			helper(root.left, list);
		}
		
		if (root.right != null) {
			helper(root.right, list);
		}
		
		if (root.left == null && root.right == null) {
			list.add(root.val);
		}
	}
	
	// Iteratively using Stack
	public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
		Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
		s1.push(root1); s2.push(root2);
		
		while (!s1.isEmpty() && !s2.isEmpty()) {
			// Compare leaf node val
			if (dfs(s1) != dfs(s2)) return false;
		}
		
		return s1.size() == s2.size();
	}
	
	public int dfs(Stack<TreeNode> s) {
		while (true) {
			TreeNode tmp = s.pop();
			if (tmp.right != null) s.push(tmp.right);
			if (tmp.left != null) s.push(tmp.left);
			if (tmp.left == null && tmp.right == null) return tmp.val;
		}
	}
}
