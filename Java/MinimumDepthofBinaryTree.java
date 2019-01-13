/*
 * LeetCode #111. Minimum Depth of Binary Tree
 * happygirlzt
 * Created on 16 Aug 2018
 */

import java.util.Queue;
import java.util.LinkedList;

public class MinimumDepthofBinaryTree {
    // iterative using queue
    public static int minDepth1(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

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

    // recursive 1
    public int findDepth(TreeNode root) {
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

        if (root.left == null) {
            return helper(root.right) + 1;
        }

        if (root.right == null) {
            return helper(root.left) + 1;
        }

        return Math.min(helper(root.left), helper(root.right)) + 1;
    }

    // recursive 2
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }


    // Updated on 16 Sep 2018
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return root.left != null ? minDepth(root.left) + 1 : minDepth(root.right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = null;
        tree.left.right = null;
        tree.right.left = new TreeNode(2);

        System.out.println(minDepth1(tree));
    }
}
