/**
 * LeetCode # 687. Longest Univalue Path
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */

public class LongestUnivaluePath {
	// DFS
	// !!!Wrong solution
	public static int longestUnivaluePath(TreeNode root) {
		if (root == null)
			return 0;
		int[] res = new int[1];
		int[] cur = new int[1];
		int[] now = new int[1];
		now[0] = root.val;
		helper(root, root, res, cur, now);

		return res[0];
	}

	/**
	 * 问题可能是。。即使现在节点的值和now一样，它们也可能是不相连的。。
	 * 看了一下人家的解法，其实我和他们的想法很接近了，但是差一点。。
	 * 还差点recursive的精髓。。还要仔细思考一下。。
	 * @param root 当前节点
	 * @param start 从哪个节点开始计数，到现在都是相同的
	 * @param res 最大的路径长度，也就是最终结果
	 * @param cur 当前正在记录的路径长度
	 * @param now 当前记录的路径的节点的值
	 */
	public static void helper(TreeNode root, TreeNode start, int[] res, int[] cur, int[] now) {
		if (root == null)
			return;

		if (root.left != null) {
			// 当前节点的值和左子树节点值相同
			if (root.left.val == root.val) {
				// 如果目前累加的path的节点值和当前值相同，也就是可以继续累加
				if (root.left.val == now[0]) {
					cur[0] += 1;
					res[0] = Math.max(res[0], cur[0]);
					// System.out.println("now is " + now);
					helper(root.left, root, res, cur, now);
				} else {
					// 如果当前这个可以相加的path的节点值，不等于目前已经累加的节点值，就重新开始加
					// cur[0]置为1， now = root.left.val
					cur[0] = 1;
					res[0] = Math.max(res[0], cur[0]);
					System.out.println("now is " + now + "root.left.val is " + root.left.val);
					now[0] = root.left.val;
					helper(root.left, root.left, res, cur, now);
				}
			} else {
				// 当前节点的值和左子树不同，继续向下
				if (res[0] == 0) {
					now[0] = root.left.val;
					helper(root.left, root.left, res, cur, now);
				} else {
					helper(root.left, root.left, res, cur, now);
				}
			}
		}

		if (root.right != null) {
			// 当前节点值和右子树节点值相同，需要累加path了
			if (root.right.val == root.val) {
				// 当前节点值和在累加的值相同，就是可以继续累加
				if (root.right.val == now[0]) {
					cur[0] += 1;
					res[0] = Math.max(res[0], cur[0]);
					// System.out.println("now is " + now);
					helper(root.right, root, res, cur, now);
				} else {
					// 当前节点值和累加的值不同，要重新累加
					// cur[0]置为1，now = root.right.val
					cur[0] = 1;
					res[0] = Math.max(res[0], cur[0]);
					// System.out.println("now is " + now);
					now[0] = root.right.val;
					helper(root.right, root.right, res, cur, now);
				}
			} else {
				// 当前节点的值和右子树不同，继续向下
				if (res[0] == 0) {
					now[0] = root.right.val;
					helper(root.right, root.right, res, cur, now);
				} else {
					helper(root.right, root.right, res, cur, now);
				}
			}
		}
	}

	/**
	 * 这道题用递归来做，一根节点为当前接单，分别左右子树的最长路径，
	 * 如果root.val 和左右子树一样，那么就+1
	 * @param root
	 * @return
	 */
	public int longestUnivaluePath1(TreeNode root) {
		if (root == null) return 0;
		
		int[] res = new int[1];
		res[0] = 0;
		dfs(root, root, res);
		
		return res[0];
	}
	
	/**
	 * 注意要有返回值。。这样会容易很多。。毕竟要求值，所以下次记得
	 * 这种要记录当前值的，需要有返回值
	 * @param root
	 * @param start
	 * @param res
	 * @return
	 */
	public int dfs(TreeNode root, TreeNode start, int[] res) {
		// base case
		if (root == null) return 0;
		
		int left = dfs(root.left, root, res);
		int right = dfs(root.right, root, res);
		
		if (root.left != null && root.left.val == root.val) {
			left += 1;
		} else {
			left = 0;
		}
		
		if (root.right != null && root.right.val == root.val) {
			right += 1;
		} else {
			right = 0;
		}
		
		res[0] = Math.max(res[0], left + right);
		return Math.max(left, right);
	}
	
	private int longest;
	// More concise solution
	public int longestUnivaluePath2(TreeNode root) {
		if (root == null) return 0;
		helper1(root, root.val);
		
		return longest;
	}
	
	public int helper1(TreeNode root, int rootVal) {
		if (root == null) return 0;
		
		int left = helper1(root.left, root.val);
		int right = helper1(root.right, root.val);
		
		longest = Math.max(longest, left + right);
		if (root.val == rootVal) return Math.max(left, right) + 1;
		return 0;
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(4);
		tree.right = new TreeNode(5);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(4);
		tree.right.right = new TreeNode(5);

		System.out.println(longestUnivaluePath(tree));
	}
}
