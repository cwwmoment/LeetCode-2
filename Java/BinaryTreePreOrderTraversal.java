
/*
 * LeetCode # 144. Binary Tree Preorder Traversal
 * happygirlzt
 * Created on 15 Aug 2018
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
	
	// iterative
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			
			if (cur.right != null) stack.push(cur.right);
			if (cur.left != null) stack.push(cur.left);
			
			res.add(cur.val);
		}
		
		return res;
	}
	
	// recursive
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(res, root);
		
		return res;
	}
	
	public void helper(List<Integer> res, TreeNode root) {
		if (root == null) return;
		
		res.add(root.val);
		helper(res, root.left);
		helper(res, root.right);
	}
}
