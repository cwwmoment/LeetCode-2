/**
 * Created on 24 Sep 2018 by happygirlzt
 *
 * LeetCode #513. Find Bottom Left Tree Value
 */
import java.util.Queue;
import java.util.LinkedList;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            root = q.poll();

            if (root.right != null) {
                q.offer(root.right);
            }

            if (root.left != null) {
                q.offer(root.left);
            }
        }

        return root.val;
    }
}
