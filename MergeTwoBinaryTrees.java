public class MergeTwoBinaryTrees {
	// Solution 1
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        TreeNode NewNode = new TreeNode(t1.val + t2.val);

        NewNode.left = mergeTrees1(t1.left, t2.left);
        NewNode.right = mergeTrees1(t1.right, t2.right);

        return NewNode;
    }

    // Solution2
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        t1.val += t2.val;

        t1.left = mergeTrees2(t1.left, t2.left);
        t1.right = mergeTrees2(t1.right, t2.right);

        return t1;
    }
}
