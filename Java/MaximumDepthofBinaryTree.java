/*
 * LeetCode #104. Maximum Depth of Binary Tree
 * happygirlzt
 * Created on 16 Aug 2018
 */
import java.util.Queue;
import java.util.LinkedList;

public class MaximumDepthofBinaryTree {
    // iteative
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            depth++;
        }

        return depth;
    }

    // recursive
    public int maxDepth2(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode root) {
        // corner case
        if (root == null)
            return 0;

        // base case
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.right == null) {
            return helper(root.left) + 1;
        }

        if (root.left == null) {
            return helper(root.right) + 1;
        }

        return Math.max(helper(root.right), helper(root.left)) + 1;
    }

    // recursive 2
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
    // Updated on 16 Sep 2018
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        } else {
            return (root.left != null) ? maxDepth(root.left) + 1 : maxDepth(root.right) + 1;
        }
    }
}
