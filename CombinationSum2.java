
/**
 * LeetCode #40. Combination Sum II
 * 
 * Created by happygirlzt on 30 Aug 2018 at 10:10:39 AM
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
	/**
	 * 这题和#39差不多，只有一点细微的差别，在递归那里start需要增1
	 * 还需要判断是否tmp已经存在res中了。
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates.length == 0)
			return res;
        Arrays.sort(candidates);
		backtrack(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}

	public void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums, int remain, int start) {
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			if (!res.contains(tmp)) {
				res.add(new ArrayList<>(tmp));
			}
		} else {
			for (int i = start; i < nums.length; i++) {
				tmp.add(nums[i]);
				backtrack(res, tmp, nums, remain - nums[i], i + 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
