/**
 * TODO: Have a problem!
 * Created on 30 Nov 2018 by happygirlzt
 *
 * LeetCode #491. Increasing Subsequences
 *
 */

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helper(res, nums, new ArrayList<>(), 0);

        return new LinkedList<>(res);
    }

    public void helper(Set<List<Integer>> res, int[] nums, List<Integer> cur, int index) {
        if (cur.size() > 1) {
            // 有什么区别？
            // res.add(cur);
            res.add(new ArrayList<>(cur));
        }

        for (int i = index; i < nums.length; i++) {
            if ((cur.size() != 0 && nums[i] >= cur.get(cur.size() - 1)) ||
                (cur.size() == 0)) {
                cur.add(nums[i]);
                helper(res, nums, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
