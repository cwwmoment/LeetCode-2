/**
 * LeetCode #222. Count Complete Tree Nodes
 * 
 * Created by happygirlzt on 4 Sep 2018 at 9:33:07 AM
 *
 */
import java.util.Queue;
import java.util.LinkedList;

public class CountCompleteTreeNodes {
	// cannot traversal, when the tree has too many nodes
    // 完全二叉树的性质是，如果最左边的的高度和最右边的高度一样，那么这就是棵完美二叉树；否则
	// 这棵完全二叉树的所有节点就为左边的完美二叉树+右边的完美二叉树+本身的节点数
	// 还要注意一下 1 << m的运用，这个等于2^m
	public int countNodes(TreeNode root) {
		return count(root, -1, -1);
	}

	public int count(TreeNode root, int left, int right) {
		if (left == -1) {
			left = 0;
			TreeNode cur = root;
			while (cur != null) {
				left++;
				cur = cur.left;
			}
		}
		
		if (right == -1) {
			right = 0;
			TreeNode cur = root;
			while (cur != null) {
				right++;
				cur = cur.right;
			}
		}
		
		if (left == right) {
			return (1 << left) - 1;
		} else {
			return count(root.left, left--, -1) + count(root.right, -1, right--) + 1;
		}
	}
	
	// Use queue
	public int countNodes1(TreeNode root) {
		if (root == null) return 0;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int count = 1;
		
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			
			if (cur.val != -5) {
				cur.val = -5;
				
				if (cur.left != null) {
					q.offer(cur.left);
					count++;
				}
				
				if (cur.right != null) {
					q.offer(cur.right);
					count++;
				}
			}
		}
		
		return count;
	}
}
