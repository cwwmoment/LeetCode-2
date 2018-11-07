/**
 * Created on 7 Nov 2018 by happygirlzt
 *
 * LeetCode #863. All Nodes Distance K in Binary Tree
 *
 */

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

    }
}
