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
            helper(root.left, sum);
        }

        if (root.right != null) {
            helper(root.right, sum);
        }
    }

    // Updated on 2 Mar 2019
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null) {
            if (isLeaf(root.left)) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }

        res += sumOfLeftLeaves(root.right);

        return res;
    }

    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) return true;
        return false;
    }
}
