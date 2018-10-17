
/**
 * LeetCode #77. Combinations
 * 
 * Created by happygirlzt on 1 Sep 2018 at 8:30:27 PM
 *
 */

import java.util.List;
import java.util.ArrayList;

/**
 * Input: n = 4, k = 2 Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 *
 */

// 这是道组合题。。不是求排列
public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (n == 0 || k == 0) {
			return res;
		}

		backtrack(res, new ArrayList<>(), k, 1, n);
		
		return res;
	}
	
	public static void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int k, int start, int n) {
		if (tmp.size() == k) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		
		for (int i = start; i <= n; i++) {
			tmp.add(i);
			backtrack(res, tmp, k, i + 1, n);
			tmp.remove(tmp.size() - 1);
		}
	}
	public static void exchange(int[] nums, int l, int r) {
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = combine(4, 2);
		System.out.println(res);
	}
}
