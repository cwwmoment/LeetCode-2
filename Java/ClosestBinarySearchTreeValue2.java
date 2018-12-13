/**
 * Created on 13 Dec 2018 by happygirlzt
 *
 * LeetCode #272. Closest Binary Search Tree Value II
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // My naive solution.. very slow
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();

        List<Integer> values = new LinkedList<>();
        helper(values, root);

        double[][] ab = new double[values.size()][2];
        int idx = 0;
        for (int i : values) {
            ab[idx][0] = Math.abs(i - target);
            ab[idx][1] = idx;
            idx++;
        }

        Arrays.sort(ab, (p1, p2) -> {
                if (p1[0] > p2[0]) {
                    return 1;
                } else {
                    return -1;
                }
            });

        //for (double[] d : ab) {
        //  System.out.println(d[0] + " " + d[1]);
        //}
        for (int j = 0; j < k; j++) {
            res.add(values.get((int) ab[j][1]));
        }

        return res;
    }

    private void helper(List<Integer> values, TreeNode root) {
        if (root.left != null) {
            helper(values, root.left);
        }

        values.add(root.val);

        if (root.right != null) {
            helper(values, root.right);
        }
    }

    // Others' solution
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        dfs(res, root, target, k);
        return res;
    }

    private void dfs(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null) {
            return;
        }
        dfs(res, root.left, target, k);
        if (res.size() == k) {
            if (Math.abs(root.val - target) < Math.abs(res.peekFirst() - target)) {
                res.removeFirst();
            } else {
                return;
            }
        }
        res.add(root.val);
        dfs(res, root.right, target, k);
    }
}
