/*
 * LeetCode 100. Same Tree
 * happygirlzt
 * Created on 15 Aug 2018
 */
import java.util.Stack;

public class SameTree {
    // recursive
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {
            if (p.val == q.val) {
                return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
            }
        }

        return false;
    }

    // iterative
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        Stack<TreeNode> st_p = new Stack<>();
        Stack<TreeNode> st_q = new Stack<>();

        TreeNode cur_p = p;
        TreeNode cur_q = q;

        while ((!st_p.isEmpty() && !st_q.isEmpty()) || (cur_p != null && cur_q != null)) {

            while (cur_p != null) {
                st_p.push(cur_p);
                cur_p = cur_p.left;
            }

            while (cur_q != null) {
                st_q.push(cur_q);
                cur_q = cur_q.left;
            }

            cur_p = st_p.pop();
            cur_q = st_q.pop();

            if (cur_p.val != cur_q.val)
                return false;

            cur_p = cur_p.right;
            cur_q = cur_q.right;
        }

        if ((cur_p == null && cur_q != null) || (cur_p != null && cur_q == null)) {
            return false;
        }
        return true;
    }

    // still iterative
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Stack<TreeNode> st_p = new Stack<>();
        Stack<TreeNode> st_q = new Stack<>();

        if (p != null)
            st_p.push(p);
        if (q != null)
            st_q.push(q);

        while (!st_p.isEmpty() && !st_q.isEmpty()) {
            TreeNode pt = st_p.pop();
            TreeNode qt = st_q.pop();

            if (pt.val != qt.val)
                return false;

            if (pt.left != null)
                st_p.push(pt.left);
            if (qt.left != null)
                st_q.push(qt.left);

            if (st_p.size() != st_q.size())
                return false;

            if (pt.right != null)
                st_p.push(pt.right);
            if (qt.right != null)
                st_q.push(qt.right);

            if (st_p.size() != st_q.size())
                return false;
        }

        return (st_p.size() == st_q.size());
    }

    // 3 Sep 2018
    public boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) {
            return isSameTree3(p.left, q.left) && isSameTree3(p.right, q.right);
        } else {
            return false;
        }
    }

    // 13 Jan 2019
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return p == null;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
