/**
 * LeetCode #112. Path Sum
 *
 * Created on 2018-8-24 by happygirlzt
 *
 * Modified on 4 Dec 2018
 */

import java.util.HashMap;

public class PathSum {
    // My naive solution
    public static boolean hasPathSum1(TreeNode root, int sum) {
        boolean res = false;
        if (root == null) {
            return res;
        }

        HashMap<Character, Boolean> map = new HashMap<>();
        map.put('a', false);

        helper(root, map, 0, sum);
        return map.get('a');
    }

    // As the boolean is a primitive data type, so the change will not pass!!!
    public static void helper(TreeNode root, HashMap<Character, Boolean> resmap, int sum, int target) {

        if (root.left != null) {
            helper(root.left, resmap, sum + root.val, target);
        }

        if (root.right != null) {
            helper(root.right, resmap, sum + root.val, target);
        }

        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                resmap.remove('a');
                resmap.put('a', true);
            }
        }
    }

    // Others' concise solution
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return (sum - root.val) == 0;
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }

    // Updated on 4 Dec 2018
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        HashSet<Integer> set = new HashSet<>();
        helper(root, set, root.val);

        // System.out.println(set);
        return set.contains(sum);
    }

    public void helper1(TreeNode root, HashSet<Integer> set, int tmp) {
        if (root != null && root.left == null && root.right == null) {
            set.add(tmp);
            return;
        }

        if (root.left != null) {
            helper1(root.left, set, tmp + root.left.val);
        }

        if (root.right != null) {
            helper1(root.right, set, tmp + root.right.val);
        }

    }
}
