
/**
 * LeetCode #257. Binary Tree Path Created on 2018-8-24
 * 
 * @author happygirlzt
 *
 */
import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths {
	/**
	 * 这又是一道用dfs的题目。。虽然我很快想到了，但是还是没有写出来。
	 * 是求从root到所有leaf的路径，是很明显的深度优先搜索。。
	 * @param root
	 * @return List<String> res
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root != null) {
			helper(root, "", res);
		}
		return res;
	}

	public void helper(TreeNode root, String s, List<String> res) {
		if (root.left == null && root.right == null) {
			res.add(s + root.val);
		}

		if (root.left != null) {
			helper(root.left, s + root.val + "->", res);
		}

		if (root.right != null) {
			helper(root.right, s + root.val + "->", res);
		}
	}
}
