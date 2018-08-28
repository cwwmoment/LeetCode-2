
/**
 * LeetCode #429. N-ary Tree Level Order Traversal
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null)
			return res;

		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			List<Integer> tmp = new LinkedList<>();
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				tmp.add(cur.val);
				
				if (cur.children.size() != 0) {
					for (Node node : cur.children) {
						q.offer(node);
					}
				}
			}

			res.add(tmp);
		}
		return res;
	}
}
