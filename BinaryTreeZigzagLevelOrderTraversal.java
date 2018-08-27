
/**
 * LeetCode #103. Binary Tree Zigzag Level Order Traversal
 * 
 * @author happygirlzt
 *
 */

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeZigzagLevelOrderTraversal {
	// Iteratively using queue
	// Solution 0 : my naive solution
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// 注意一下二维List的声明方式
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null)
			return res;

		Queue<TreeNode> q = new LinkedList<>();
		TreeNode cur = root;
		q.offer(cur);

		List<Integer> l = new LinkedList<>();
		l.add(cur.val);
		res.add(l);

		while (true) {
			int count = q.size();
			if (count == 0)
				break;

			LinkedList<Integer> list = new LinkedList<>();

			while (count > 0) {
				cur = q.poll();

				if (cur.left != null) {
					q.offer(cur.left);
					list.add(cur.left.val);
				}

				if (cur.right != null) {
					q.offer(cur.right);
					list.add(cur.right.val);
				}
				
				count--;
			}
			
			if (list.size() != 0) {
				if ((res.size() + 1 )% 2 == 0) {
				  res.add(reverse(list));
				} else {
					res.add(list);
				}
			}
		}

		return res;
	}
	
	public List<Integer> reverse(List<Integer> l) {
		LinkedList<Integer> re = new LinkedList<>();
		for (Integer i : l) {
			re.addFirst(i);
		}
		return re;
	}
	
	// Solution 1: much clearer solution
	public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		
		if (root == null)
			return res;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while (!q.isEmpty()) {
			LinkedList<Integer> list = new LinkedList<>();
			// 用一个变量来存q的大小，很重要！关键！
			int count = q.size();
			
			for (int i = 0; i < count; i++) {
				TreeNode cur = q.poll();
				
				if (res.size() % 2 == 0) {
					list.add(cur.val);
				} else {
					list.addFirst(cur.val);
				}
				
				if (cur.left != null) {
					q.offer(cur.left);
				}
				
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}
			
			res.add(list);
		}
		
		return res;
	}
	
	// Recursive
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root, res, 0);
		
		return res;
	}
	
	public void dfs(TreeNode root, List<List<Integer>> res, int level) {
		if (root == null) return;
		
		if (res.size() <= level) {
			List<Integer> list = new ArrayList<>();
			res.add(list);
		}
		
		if (level % 2 == 0) {
			res.get(level).add(root.val);
		} else {
			res.get(level).add(0, root.val);
		}
		
		dfs(root.left, res, level + 1);
		dfs(root.right, res, level + 1);
	}
}
