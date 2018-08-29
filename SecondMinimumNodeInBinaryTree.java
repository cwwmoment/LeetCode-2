
/**
 * LeetCode # 671. Second Minimum Node In a Binary Tree Created on 2018-08-28
 * 
 * @author happygirlzt
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SecondMinimumNodeInBinaryTree {
	// 我的弱智的做法。。
	public int findSecondMinimumValue(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		helper(root, list, set);

		Integer[] array = list.toArray(new Integer[list.size()]);
		Arrays.sort(array);
		if (array.length < 2) {
			return -1;
		} else {
			return array[1];
		}
	}

	public void helper(TreeNode root, List<Integer> list, HashSet<Integer> set) {
		if (root == null)
			return;

		if (root.left != null && root.right != null) {
			if (set.add(Math.min(root.left.val, root.right.val))) {
				list.add(Math.min(root.left.val, root.right.val));
			}
		}

		if (root.left == null && root.right == null) {
			if (set.add(root.val)) {
				list.add(root.val);
			}
		}

		if (root.left != null) {
			helper(root.left, list, set);
		}

		if (root.right != null) {
			helper(root.right, list, set);
		}
	}
	
	// 这题的特别之处在于，根节点的值是小于或等于两个子节点的值的，所以如果各节点的值
	// 已经比当前最小值大了，那就不需要遍历两个子节点了
	public int findSecondMinimumValue1(TreeNode root) {
		if (root == null) return -1;
		return dfs(root, root.val);
	}
	
	public int dfs(TreeNode root, int s1) {
		if (root == null) return -1;
		if (root.val > s1) return root.val;
		
		int sl = dfs(root.left, s1);
		int sr = dfs(root.right, s1);
		
		if (sl == -1) return sr;
		if (sr == -1) return sl;
		
		return Math.min(sl, sr);
	}
}
