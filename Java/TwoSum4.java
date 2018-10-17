import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * LeetCode # 653. Two Sum IV - Input is a BST
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */
public class TwoSum4 {
	// My naive solution: 真的是不知道，为什么我这么蠢= =
	// 其实已经很接近比较科学的答案了。。真的是太菜了
	public static boolean findTarget(TreeNode root, int k) {
		if (root == null) return false;
		
		StringBuilder sb = new StringBuilder();
		inorder(root, sb);
		String[] s = sb.toString().split(" ");
		ArrayList<Integer> list = new ArrayList<>();
		for (String number : s) {
		    list.add(Integer.valueOf(number));
		}
		
		// System.out.println(list);
		int i = 0, j = list.size() - 1;
		while (i < j) {
			if (list.get(i) + list.get(j) == k) {
				return true;
			} else if (list.get(i) + list.get(j) < k) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}
	
	public static void inorder(TreeNode root, StringBuilder sb) {
		if (root == null) return;
		
		if (root.left != null) {
			inorder(root.left, sb);
		}
		
		sb.append(root.val);
		sb.append(" ");
		
		if (root.right != null) {
			inorder(root.right,  sb);
		}
	}
	
	// Modified naive solution
	// Time complexity: O(n), Space complexity: O(n)
	public boolean findTarget1(TreeNode root, int k) {
		if (root == null) return false;
		List<Integer> nums = new ArrayList<>();
		helper(root, nums);
		
		for (int i = 0, j = nums.size() - 1; i < j;) {
			if (nums.get(i) + nums.get(j) == k) {
				return true;
			} else if (nums.get(i) + nums.get(j) < k) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}
	
	public void helper(TreeNode root, List<Integer> nums) {
		if (root == null) return;
		if (root.left != null) {
			helper(root.left, nums);
		}
		nums.add(root.val);
		
		if (root.right != null) {
			helper(root.right, nums);
		}
	}
	
	// HashSet
	// Time complexity: O(n), Space complexity: O(n)
	public boolean findTarget2(TreeNode root, int k) {
		Set<Integer> set = new HashSet<>();
		
		return dfs(root, set, k);
	}
	
	public boolean dfs(TreeNode root, Set<Integer> set, int k) {
		if (root == null) return false;
		
		if (set.contains(k - root.val)) {
			return true;
		}
		
		set.add(root.val);
		
		return dfs(root.left, set, k) || dfs(root.right, set, k);
	}
	public static void main(String[] args) {
		// 5,3,6,2,4,null,7
		// [0,-1,2,-3,null,null,4]
		TreeNode tree = new TreeNode(0);
		tree.left = new TreeNode(-1);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(-3);
		// tree.left.right = new TreeNode();
		tree.right.right = new TreeNode(4);
		
		System.out.println(findTarget(tree, -4));
	}
}
