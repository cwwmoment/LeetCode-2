/**
 * Created on 5 Dec 2018 by happygirlzt
 *
 * LeetCode #655. Print Binary Tree
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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int row = depth(root);
        int col = (int) Math.pow(2, row) - 1;

        List<String> inner = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            inner.add("");
        }

        for (int j = 0; j < row; j++) {
            res.add(new ArrayList<>(inner));
        }

        helper(root, res, 0, 0, col - 1);

        return res;
    }

    public void helper(TreeNode root, List<List<String>> res, int row, int beg, int end) {
        if (root == null) return;

        int mid = (end + beg) >> 1;
        res.get(row).set(mid, String.valueOf(root.val));

        helper(root.left, res, row + 1, beg, mid - 1);
        helper(root.right, res, row + 1, mid + 1, end);
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
