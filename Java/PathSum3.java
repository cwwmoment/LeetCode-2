/**
 * LeetCode #437. Path Sum III
 *
 * Created by happygirlzt on 29 Aug 2018 at 9:22:22 PM
 *
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathhelper(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return res;
        if (sum == root.val) {
            res++;
        }
        res += pathhelper(root.left, sum - root.val);
        res += pathhelper(root.right, sum - root.val);

        return res;
    }

    // Other's smart solution
    public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
