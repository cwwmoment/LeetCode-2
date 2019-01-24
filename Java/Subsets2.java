/**
 * Created on 21 Oct 2018 by happygirlzt
 *
 * LeetCode #90. Subsets II
 *
 */

public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            backtrack(nums, i, 0, res, new ArrayList<>());
        }

        return res;
    }

    public void backtrack(int[] nums, int k, int start, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (start != i && nums[i] == nums[i - 1]) {
                continue;
            }

            cur.add(nums[i]);
            backtrack(nums, k, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }

    // Updated on 24 Jan 2019
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        helper(res, cur, 0, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int start, int[] nums) {
        if (start == nums.length) {
            res.add(new ArrayList(cur));
            return;
        } else {
            cur.add(nums[start]);
            helper(res, cur, start + 1, nums);
            cur.remove(cur.size() - 1);

            while (start < nums.length - 1 && nums[start + 1] == nums[start]) start++;
            helper(res, cur, start + 1, nums);
        }
    }
}
