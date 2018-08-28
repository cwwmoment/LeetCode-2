
/**
 * Used in N-nary Tree
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */
import java.util.List;

public class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
