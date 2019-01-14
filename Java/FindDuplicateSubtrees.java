/**
 * Created on 14 Jan 2019 by happygirlzt
 *
 * LeetCode #652. Find Duplicate Subtrees
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(map, res, root);
        return res;
    }

    private String helper(Map<String, Integer> map, List<TreeNode> res, TreeNode root) {
        if (root == null) return "#";
        String str = root.val + "," + helper(map, res, root.left) + "," + helper(map, res, root.right);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) {
            res.add(root);
        }

        return str;
    }
}
