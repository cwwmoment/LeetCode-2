/**
 * LeetCode #572. Subtree of Another Tree
 *
 * Created by happygirlzt on 3 Sep 2018 at 11:45:01 AM
 *
 */
public class SubtreeOfAnotherTree {
    // 这题的就是在大的树上找到和小树根节点相同的值，然后看两个树是否相同
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;

        if (check(s, t)) return true;
        return check(s.left, t) || check(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (t == null && s == null)
            return true;

        if (t == null || s == null)
            return false;

        if (s.val != t.val) return false;

        return check(s.left, t.left) && check(s.right, t.right);
    }
}
