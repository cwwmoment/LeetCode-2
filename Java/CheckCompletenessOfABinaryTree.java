/**
 * Created on 16 Dec 2018 by happygirlzt
 *
 * LeetCode 958. Check Completeness of a Binary Tree
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        boolean hasNullNode = false;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                if (hasNullNode) return false;
                q.offer(cur.left);
            } else {
                hasNullNode = true;
            }

            if (cur.right != null) {
                if (hasNullNode) return false;
                q.offer(cur.right);
            } else {
                hasNullNode = true;
            }
        }

        return true;
    }
}
