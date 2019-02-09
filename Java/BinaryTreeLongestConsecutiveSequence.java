/**
 * Created on 19 Dec 2018 by happygirlzt
 *
 * LeetCode #298. Binary Tree Longest Consecutive Sequence
 *
 */

class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return helper(root, root.val + 1, 1, 1);
    }

    private int helper(TreeNode node, int target, int curr, int max) {
        if (node == null) return max;
        if (node.val == target) {
            curr++;
            max = Math.max(curr, max);
        } else {
            curr = 1;
        }

        return Math.max(helper(node.left, node.val + 1, curr, max),
                        helper(node.right, node.val + 1, curr, max));
    }

    // Updated on 9 Feb 2019
    private int maxLen = 0;
    public int longestConsecutive1(TreeNode root) {
        dfs(root);
        return maxLen;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int L = dfs(root.left) + 1;
        int R = dfs(root.right) + 1;
        if (root.left != null && root.val + 1 != root.left.val) {
            L = 1;
        }
        if (root.right != null && root.val + 1 != root.right.val) {
            R = 1;
        }
        int len = Math.max(L, R);
        maxLen = Math.max(maxLen, len);
        return len;
    }
}
