/**
 * Created on 16 Sep 2018 by happygirlzt
 *
 * LeetCode #230. Kth Smallest Element in a BST
 */

public class KthSmallestElementInABST {
    // My naive solution
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;

        List<Integer> list = new ArrayList<>();

        helper(list, root);

        return list.get(k - 1);
    }

    public void helper(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            helper(list, root.left);
        }

        list.add(root.val);

        if (root.right != null) {
            helper(list, root.right);
        }
    }

    // Other's smart solution
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[]{0, -1};
        helper(root, k, res);
        return res[1];
    }

    public void helper(TreeNode root, int k, int[] a) {
        if (root == null) return;
        helper(root.left, k, a);

        if (++a[0] == k) a[1] = root.val;

        if (a[0] < k) helper(root.right, k, a);
    }
}
