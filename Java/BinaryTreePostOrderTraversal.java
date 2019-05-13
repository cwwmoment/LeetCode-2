/**
 * LeetCode #145. Binary Tree Postorder Traversal
 * happygirlzt
 * Created on 15 Aug 2018
 *
 */
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreePostOrderTraversal {

    // iterative solution 1
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                res.add(0, root.val);
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop().left;
            }
        }

        return res;
    }

    // iterative solution 2
    public List<Integer> postorderTraversel(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        return res;
    }
    // recursive
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);

        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;

        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}
