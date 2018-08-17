/*
 * Created on 15 Aug 2018
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
	
	public void show(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.val + " ");
		}
		
		if (tree.left != null) show(tree.left);
		if (tree.right != null) show(tree.right);
		
		return;
	}
}
