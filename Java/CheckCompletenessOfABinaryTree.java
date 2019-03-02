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

    // Updated on 2 Mar 2019
    public boolean isCompleteTree1(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean seen = false;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.left == null && cur.right != null) return false;

                if (cur.left != null) {
                    if (seen) return false;
                    q.offer(cur.left);
                } else seen = true;

                if (cur.right != null) {
                    if (seen) return false;
                    q.offer(cur.right);
                } else {
                    seen = true;
                }
            }
        }

        return true;
    }
}
