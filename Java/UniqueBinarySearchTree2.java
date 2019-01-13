/**
 * LeetCode # 95. Unique Binary Search Trees II
 *
 * Created on 2018-08-26
 *
 * @author happygirlzt
 *
 */
import java.util.ArrayList;

public class UniqueBinarySearchTree2 {
    /**
     * 以i为根节点的树，其左子树由[1, i-1]构成， 其右子树由[i+1, n]构成。
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList();

        return helper(1, n);
    }

    public List<TreeNode> helper(int left, int right) {
        List<TreeNode> res = new ArrayList<>();

        // base case
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            // i is the root
            List<TreeNode> lefts = helper(left, i - 1);
            List<TreeNode> rights = helper(i + 1, right);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {

                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;

                    res.add(root);
                }
            }
        }

        return res;
    }
}
