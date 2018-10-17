
/**
 * LeetCode #129. Sum Root to Leaf Numbers
 * 
 * Created on 2018-08-27
 * 
 * @author happygirlzt
 *
 */
public class SumRoot2LeafNumbers {
	public static int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public static int sum(TreeNode n, int s){
		if (n == null) return 0;
		
		if (n.right == null && n.left == null) return s*10 + n.val;
		return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);

		System.out.println(sumNumbers(tree));

	}
}
