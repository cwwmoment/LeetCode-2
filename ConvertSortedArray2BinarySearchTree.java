/**
 * LeetCode #108. Convert Sorted Array to Binary Search Tree
 * 
 * Created on 2018-08-27
 * 
 * @author happygirlzt
 *
 */

public class ConvertSortedArray2BinarySearchTree {
	/**
	 * 哇的一下就哭出来了，这题明明和昨天做的一样。。为什么我还是不会做！
	 * 哭唧唧QAQ看了昨天的解法才恍然大悟。
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0 || nums == null) return null;
		
		return helper(nums, 0, nums.length - 1);
	}
	
	public TreeNode helper(int[] nums, int left, int right) {
		// Base case
		if (left > right) return null;
		
		int mid = (left + right) >> 1;
		TreeNode root = new TreeNode(nums[mid]);
		
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		
		return root;
	}
}
