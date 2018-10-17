/**
 * LeetCode #606. Construct String from Binary Tree
 * 
 * Created by happygirlzt on 3 Sep 2018 at 10:24:18 AM
 *
 */

public class ConstructStringFromBinaryTree {
	public static String tree2str(TreeNode t) {
		StringBuilder res = new StringBuilder();
		if (t == null)
			return res.toString();

		construct(res, t);
		return res.toString();
	}

	public static void construct(StringBuilder res, TreeNode t) {
		if (t == null) {
			return;
		}

		res.append(t.val);

		// 我原始的写法
//		if (t.left != null) {
//			res.append("(");
//			construct(res, t.left);
//			res.append(")");
//		} else if (t.left == null && t.right != null) {
//			res.append("()");
//		}

		if (t.left != null || t.right != null) {
			res.append("(");
			construct(res, t.left);
			res.append(")");
		}

		if (t.right != null) {
			res.append("(");
			construct(res, t.right);
			res.append(")");
		}
	}
}