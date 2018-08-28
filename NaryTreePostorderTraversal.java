
/**
 * LeetCode #590. N-ary Tree Postorder Traversal
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */
import java.util.List;

import java.util.LinkedList;

public class NaryTreePostorderTraversal {
	public List<Integer> postorder(Node root) {
		List<Integer> res = new LinkedList<>();

		if (root == null)
			return res;
		
		helper(root, res);
		
		return res;
	}
	
	public void helper(Node root, List<Integer> res) {
		if (root == null) return;
		
		if (root.children.size() != 0) {
			for (Node node: root.children) {
				helper(node, res);
			}
		}
		
		res.add(root.val);
	}
}
