
/**
 * LeetCode #563. Binary Tree Tilt
 * 
 * Created on 2018-08-26
 * 
 * @author happygirlzt
 *
 */
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeTilt {
	// Post order Recursive
	/**
	 * 感觉自己智商好低啊。。虽然知道Java函数是传值的，所以为了值能传下去，
	 * 就用了对象。。。专门开了hashmap（什么弱智操作？？？
	 * 最简单的方法就是开一个全局变量啊，摔！
	 * @param root
	 * @return
	 */

	// Native solution
	public int findTilt(TreeNode root) {
		if (root == null)
			return 0;

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('a', 0);
		helper(root, map);

		return map.get('a');
	}

	public int helper(TreeNode root, HashMap<Character, Integer> m) {
		if (root == null)
			return 0;

		int rightSum = helper(root.right, m);

		int leftSum = helper(root.left, m);

		int tmp = m.get('a');

		tmp += Math.abs(leftSum - rightSum);
		m.remove('a');
		m.put('a', tmp);

		return leftSum + rightSum + root.val;
	}

	private static int res;
	// Much nicer
	public int findTilt2(TreeNode root) {
		if (root == null)
			return 0;

		res = 0;
		dfs(root);

		return res;
	}
	
	public int dfs(TreeNode root) {
		if (root == null) return 0;
		
		int leftSum = dfs(root.left);
		int rightSum = dfs(root.right);
		
		res += Math.abs(leftSum - rightSum);
		
		return leftSum + rightSum + root.val;
	}
	
	// Level traversal using queue
	public int findTilt1(TreeNode root) {
		if (root == null)
			return 0;
		int sum = 0;
		Queue<TreeNode> q = new LinkedList<>();

		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode cur = q.poll();

			if (cur.left != null) {
				q.offer(cur.left);
			}

			if (cur.right != null) {
				q.offer(cur.right);
			}

			if (cur.left != null && cur.right != null) {
				sum += Math.abs(cur.left.val - cur.right.val);
			} else if (cur.left == null && cur.right != null) {
				sum += cur.right.val;
			} else if (cur.left != null && cur.right == null) {
				sum += cur.left.val;
			} else {
				sum += 0;
			}
		}

		return sum;
	}
}