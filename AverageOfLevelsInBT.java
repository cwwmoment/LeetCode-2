/*
 * LeetCode #637. Average of Levels in Binary Tree
 * happygirlzt
 * Created on 20 July
 * 
 */

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class AverageOfLevelsInBT {
	public static class TreeNode {
		double val;
		TreeNode left;
		TreeNode right;

		TreeNode(double v) {
			val = v;
			left = null;
			right = null;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> result = new ArrayList<Double>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null)
			return result;

		queue.add(root);

		while (!queue.isEmpty()) {
			int n = queue.size(); // the number of nodes in each level
			double sum = 0.0; // the sum of each level

			for (int i = 0; i < n; i++) {
				TreeNode node = queue.remove();
				sum += node.val;
				if (root.left != null) {
					queue.add(root.left);
				}

				if (root.right != null) {
					queue.add(root.right);
				}
			}

			result.add(sum / n);
		}

		return result;
	}

	public static void main(String[] agrs) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

	}
}
