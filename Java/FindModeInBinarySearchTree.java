
/**
 * LeetCode # 501. Find Mode in Binary Search Tree
 * 
 * Created on 2018-08-28
 * 
 * @author happygirlzt
 *
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Arrays;
import java.util.Collection;

public class FindModeInBinarySearchTree {
	// sort HashMap by values
	public static int[] findMode(TreeNode root) {
		if (root == null)
			return null;
		HashMap<Integer, Integer> map = new HashMap<>();

		dfs(root, map);
		Collection<Integer> values = map.values();
		Integer[] a = values.toArray(new Integer[values.size()]);
		Arrays.sort(a);
		int max = a[a.length - 1];
		
		Set<Integer> keys = new HashSet<>();
	    for (Entry<Integer, Integer> entry : map.entrySet()) {
	        if (entry.getValue().equals(max)) {
	            keys.add(entry.getKey());
	        }
	    }
	    
	    int[] res = keys.stream()
	    		.mapToInt(Integer::intValue)
	    		.toArray();
	    
		return res;
	}

	public static void dfs(TreeNode root, HashMap<Integer, Integer> map) {
		if (root == null)
			return;

		if (root.left != null) {
			dfs(root.left, map);
		}

		if (map.containsKey(root.val)) {
			int tmp = map.get(root.val);
			map.replace(root.val, ++tmp);
		} else {
			map.put(root.val, 1);
		}

		if (root.right != null) {
			dfs(root.right, map);
		}
	}

	public static void main(String[] args) {
		// [5,4,8,11,null,13,4,7,2,null,null,5,1]
		// 1, 2, 2
		TreeNode tree = new TreeNode(1);
		// tree.left = new TreeNode(4);
		tree.right = new TreeNode(2);
		tree.right.left = new TreeNode(2);
		findMode(tree);
	}
}
