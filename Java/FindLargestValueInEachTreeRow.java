/**
 * Created on 7 Nov 2018 by happygirlzt
 *
 * LeetCode #515. Find Largest Value in Each Tree Row
 *
 */

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root)
            res.add(root.val);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    flag = true;
                    q.offer(cur.left);
                    max = Math.max(max, cur.left.val);
                }

                if (cur.right != null) {
                    flag = true;
                    q.offer(cur.right);
                    max = Math.max(max, cur.right.val);
                }
            }

            if (flag) res.add(max);
        }

        return res;
    }
}
