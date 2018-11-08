/**
 * Created on 8 Nov 2018 by happygirlzt
 *
 * LeetCode #117. Populating Next Right Pointers in Each Node II
 *
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            TreeLinkNode last = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = q.poll();

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }

                if (last != null) {
                    last.next = cur;
                }

                last = cur;
            }
        }
    }
}
