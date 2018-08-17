import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;

public class BTLevelOrderTraversal2 {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<List<Integer>> s = new Stack<List<Integer>>();

		if (root == null)
			return res;

		q.add(root);

		while (!q.isEmpty()) {
			int n = q.size();

			List<Integer> sub = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				TreeNode node = q.remove();

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);

				sub.add(node.val);
			}

			s.push(sub);
		}

		while (!s.isEmpty()) {
			res.add(s.pop());
		}

		return res;
	}
}
