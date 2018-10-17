/**
 * LeetCode #589. N-ary Tree Preorder Traversal
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */
import java.util.List;
import java.util.LinkedList;

public class NaryTreePreorderTraversal {
	public List<Integer> preorder(Node root) {
		List<Integer> res = new LinkedList<>();
		
		if (root == null) return res;
		
		helper(root, res);
		
		return res;
	}
	
	public void helper(Node root, List<Integer> res) {
		if (root == null) return;
		
		res.add(root.val);
		
		if (root.children.size() != 0) {
			for (Node node : root.children) {
				helper(node, res);
			}
		}
	}
}
