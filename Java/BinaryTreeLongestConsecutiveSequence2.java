/**
 * Created on 15 Jan 2019 by happygirlzt
 *
 * LeetCode #549. Binary Tree Longest Consecutive Sequence II
 *
 */

class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int inc = 1, dec = 1;
        if (root.left != null) {
            int[] left = helper(root.left);
            if (root.val == root.left.val + 1) {
                inc = left[0] + 1;
            } else if (root.val == root.left.val - 1) {
                dec = left[1] + 1;
            }
        }

        if (root.right != null) {
            int[] right = helper(root.right);
            if (root.val == root.right.val + 1) {
                inc = Math.max(inc, right[0] + 1);
            } else if (root.val == root.right.val - 1) {
                dec = Math.max(dec, right[1] + 1);
            }
        }

        max = Math.max(max, dec + inc - 1);

        return new int[]{inc, dec};
    }
}
