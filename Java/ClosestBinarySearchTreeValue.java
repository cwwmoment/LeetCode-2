/**
 * Created on 10 Dec 2018 by happygirlzt
 *
 * LeetCode #270. Closest Binary Search Tree Value
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
    public int closestValue(TreeNode root, double target) {
        int v = root.val;
        TreeNode child = root.val < target ? root.right : root.left;
        if (child == null) return v;
        int b = closestValue(child, target);
        return Math.abs(target - v) < Math.abs(target - b) ? v : b;
    }

    // Updated on 2 Mar 2019
    // O(h), just one half, do not need whole traversal
    public int closestValue1(TreeNode root, double target) {
        int res = root.val;

        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
                if (Math.abs(res - target) < 0.5) break;
            }

            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return res;
    }
}
