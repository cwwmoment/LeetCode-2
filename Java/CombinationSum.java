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
    // Updated on 26 Apr 2019
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
            }

            return;
        }

        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper(res, tmp, candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
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
