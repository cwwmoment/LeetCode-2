/**
 * Created on 19 Nov 2018 by happygirlzt
 *
 * LeetCode #386. Find Leaves of Binary Tree
 *
 */

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        helper(root, res);
        return res;
    }

    private int helper(TreeNode root, List<List<Integer>> res){
        if (root == null)  return -1;

        int level = 1 + Math.max(helper(root.left, res), helper(root.right, res));
        if (res.size() < level + 1)  res.add(new ArrayList<>());
        res.get(level).add(root.val);

        return level;
    }
}
