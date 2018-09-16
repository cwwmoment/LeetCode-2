/**
 * Created on 16 Sep 2018 by happygirlzt
 *
 * LeetCode #199. Binary Tree Right Side View
 */

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeRightSideView {
    // My naive solution
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(root);

        res.add(root.val);
        outloop:
        while (true) {
            TreeNode tmp = null;
            while (!q1.isEmpty()) {
                tmp = q1.poll();

                if (tmp.left != null) {
                    q2.offer(tmp.left);
                }

                if (tmp.right != null) {
                    q2.offer(tmp.right);
                }
            }

            if (!res.contains(tmp.val)) {
                res.add(tmp.val);
            }

            while (!q2.isEmpty()) {
                tmp = q2.poll();

                if (tmp.left != null) {
                    q1.offer(tmp.left);
                }

                if (tmp.right != null) {
                    q1.offer(tmp.right);
                }
            }

            if (!res.contains(tmp.val)) {
                res.add(tmp.val);
            }

            while (tmp == null || (q1.isEmpty() && q1.isEmpty())) break outloop;
        }

        return res;
    }

    // Other's solution: BFS
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

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

                if (i == size - 1) {
                    res.add(cur.val);
                }
            }
        }
        return res;
    }
}
