
/**
 * LeetCode # 113. Path Sum II
 * 
 * Created on 2018-08-26
 * 
 * @author happygirlzt
 */

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<>();

		if (root == null)
			return res;

		List<Integer> l = new LinkedList<>();
		helper(root, res, l, sum);
		return res;
	}

	
 	public static void helper(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum) {
		if (root == null)
			return;

		list.add(root.val);
		
		if (root.left == null && root.right == null && sum == root.val) {
				res.add(new LinkedList(list));
				list.remove(list.size() - 1);
				return;
		}

		if (root.left != null) {
			helper(root.left, res, list, sum - root.val);
		}
		if (root.right != null) {
			helper(root.right, res, list, sum - root.val);
		}
		list.remove(list.size() - 1);
	}
	
	public static void main(String[] args) {
		// [5,4,8,11,null,13,4,7,2,null,null,5,1]
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(4);
		tree.right = new TreeNode(8);
		tree.left.left = new TreeNode(11);
		
		List<List<Integer>> res = pathSum(tree, 20);
		System.out.println(res);
	}
}
