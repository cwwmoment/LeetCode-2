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
}