/**
 * 
 * Created by happygirlzt on 2 Sep 2018 at 9:47:07 AM
 *
 */
import java.util.List;
import java.util.ArrayList;

public class IncreasingOrderSearchTree {
	public TreeNode increasingBST(TreeNode root) {
		if (root == null) return root;
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		return build(list);
	}
	
	public void inOrder(TreeNode root, List<Integer> list) {
		if (root == null) return;
		if (root.left != null) {
			inOrder(root.left, list);
		}
		list.add(root.val);
		
		if (root.right != null) {
			inOrder(root.right, list);
		}
	}
	
	public TreeNode build(List<Integer> list) {
		TreeNode root = new TreeNode(0);
		TreeNode dummy = root;
		for (int i = 0; i < list.size() - 1; i++) {
			root.val = list.get(i);
			root.right = new TreeNode(0);
			root = root.right;
		}
		root.val = list.get(list.size() - 1);
		return dummy;
	}
}
