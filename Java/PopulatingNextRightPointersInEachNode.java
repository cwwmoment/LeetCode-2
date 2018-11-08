/**
 * Created on 8 Nov 2018 by happygirlzt
 *
 * LeetCode #116. Populating Next Right Pointers in Each Node
 *
 */
public class Solution {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }

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
