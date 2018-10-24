
/**
 * LeetCode 173. Binary Search Tree Iterator
 * 
 * Created on 2018-08-26
 * 
 * @author happygirlzt
 *
 */

import java.util.Stack;

public class BinarySearchTreeIterator {
	// TODO Where is the problem?
	public class BSTIterator1 {
		TreeNode root;

		public BSTIterator1(TreeNode node) {
			root = node;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			if (root == null)
				return false;
			if (root.left != null) {
				return true;
			} else {
				return false;
			}
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode dummy = root;
			while (dummy.left != null) {
				dummy = dummy.left;
			}

			return dummy.val;
		}
	}

	public class BSTIterator {
		// 中序遍历，用栈
		private Stack<TreeNode> st;

		public BSTIterator(TreeNode root) {
			st = new Stack<>();
			
			while (root != null) {
				st.push(root);
				root = root.left;
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !st.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode tmp = st.pop();
			int res = tmp.val;  // 这个写法很重要！
			if (tmp.right != null) {
				tmp = tmp.right;
				while (tmp != null) {
					st.push(tmp);
					tmp = tmp.left;
				}
			}

			return res;
		}
	}
}
/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */