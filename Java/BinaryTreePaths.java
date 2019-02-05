/**
 * LeetCode #257. Binary Tree Path Created on 2018-8-24
 *
 * @author happygirlzt
 *
 */
import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            helper(root, "", res);
        }
        return res;
    }

    public void helper(TreeNode root, String s, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(s + root.val);
        }

        if (root.left != null) {
            helper(root.left, s + root.val + "->", res);
        }

        if (root.right != null) {
            helper(root.right, s + root.val + "->", res);
        }
    }

    // Updated on 5 Feb 2019
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, "", root);
        return res;
    }

    private void helper(List<String> res, String tmp, TreeNode root) {
        if (root == null) return;
        tmp += root.val;
        if (root.left == null && root.right == null) {
            res.add(tmp);
        }

        helper(res, tmp + "->", root.left);
        helper(res, tmp + "->", root.right);
    }

    // Updated on 5 Feb 2019
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(res, sb, root);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, TreeNode root) {
        if (root == null) return;

        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        sb.append("->");
        helper(res, sb, root.left);
        helper(res, sb, root.right);
        sb.setLength(len);
    }
}
