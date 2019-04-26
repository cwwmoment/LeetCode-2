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
    // Updated on 26 Apr 2019
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, candidates, new ArrayList<>(), target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, List<Integer> tmp, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList(tmp));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            tmp.add(candidates[i]);
            helper(res, candidates, tmp, target - candidates[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    // 30 Aug 2018
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
