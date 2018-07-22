import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BTLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		if (root == null)
			return res;

		q.add(root);

		while (!q.isEmpty()) {
			List<Integer> sub = new ArrayList<Integer>();
			int n = q.size();
			
			for (int i = 0; i < n; i++) {
                TreeNode node = q.remove();
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
				
				sub.add(node.val);
			}
			
			res.add(sub);
		}
		
		return res;
	}
}
