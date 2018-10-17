
/**
 * LeetCode #39. Combination Sum
 * 
 * Created by happygirlzt on 30 Aug 2018 at 8:37:29 AM
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	// 这是一道经典的backtracking的题。。虽然我第一眼就看出来了。。但是不会做:-(
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		if (candidates.length == 0)
			return res;
		backtrack(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}

	public void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums, int remain, int start) {
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			res.add(tmp);
		} else {
			for (int i = start; i < nums.length; i++) {
				tmp.add(nums[i]);
				backtrack(res, tmp, nums, remain - nums[i], i);
				tmp.remove(nums[i]);
			}
		}
	}
}
