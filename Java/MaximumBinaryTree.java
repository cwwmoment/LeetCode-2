/**
 * LeetCode #654. Maximum Binary Tree
 *
 * Created on 2018-08-26
 *
 * @author happygirlzt
 */


public class MaximumBinaryTree {
    // Recursive
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode root = build(nums, 0, nums.length - 1);

        return root;
    }

    public TreeNode build(int[] n, int start, int end) {
        // Base case
        if (start > end) return null;
        int maxIndex = start;

        for (int i = start + 1; i <= end; i++) {
            if (n[i] > n[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(n[maxIndex]);
        root.left = build(n, start, maxIndex - 1);
        root.right = build(n, maxIndex + 1, end);

        return root;
    }
}
