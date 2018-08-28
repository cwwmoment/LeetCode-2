/**
 * LeetCode # 404. Sum of Left Leaves
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */

public class SumOfLeftLeaves {
	// My naive solution
	public static int sumOfLeftLeaves(TreeNode root) {
		int[] sum = new int[1];
		helper(root, sum);

		return sum[0];
	}

	public static void helper(TreeNode root, int[] sum) {
		if (root == null)
			return;
		if (root.left != null) {
			if (root.left.right == null && root.left.left == null) {
				sum[0] += root.left.val;
			}
			// System.out.println("Sum[0] " + sum[0]);
			helper(root.left, sum);
		}

		if (root.right != null) {
			// System.out.println("haha");
			helper(root.right, sum);
		}
	}

	// TODO check other solutions
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		// tree.right.right = new TreeNode(4);

		System.out.println(sumOfLeftLeaves(tree));
	}
}
