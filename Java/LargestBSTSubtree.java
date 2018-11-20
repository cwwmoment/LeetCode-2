/**
 * Created on 20 Nov 2018 by happygirlzt
 *
 * LeetCode #Largest BST Subtree
 *
 */

class Solution {
    // HAVE BUG!!!!
    public int largestBSTSubtree(TreeNode root) {
        int[] res = new int[1];
        helper(root, 0, 0, res);

        return res[0];
    }

    public boolean helper(TreeNode root, int l, int r, int[] res) {
        if (root == null) return true;

        boolean left = helper(root.left, l, r, res);
        boolean right = helper(root.right, l, r, res);

        if (left && right) {
            if (root.left != null) {
                if (root.left.val > root.val) {
                    l--;
                    return false;
                }
                l++;
            }

            if (root.right != null) {
                if (root.right.val <= root.val) {
                    r--;
                    return false;
                }
                r++;
            }

            res[0] = Math.max(res[0], l + r + 1);
            return true;
        }

        return false;
    }
}
