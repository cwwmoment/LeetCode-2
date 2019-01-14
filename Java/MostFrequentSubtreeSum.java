/**
 * Created on 14 Jan 2019 by happygirlzt
 *
 * LeetCode #508. Most Frequent Subtree Sum
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
// How to find the largest element in HashMap?
// Maintain a global variable and modify it every time

class Solution {
    private int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(map, root);
        List<Integer> res = new ArrayList<>();

        for (Integer candidate: map.keySet()) {
            if (map.get(candidate) == maxCount) {
                res.add(candidate);
            }
        }

        int size = res.size();
        int[] r = new int[size];
        int index = 0;
        for (int i : res) {
            r[index++] = i;
        }

        return r;
    }

    private int helper(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + helper(map, root.left) + helper(map, root.right);

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        int count = map.get(sum);
        maxCount = Math.max(count, maxCount);

        return sum;
    }
}
