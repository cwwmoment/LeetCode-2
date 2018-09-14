/**
 * LeetCode #47. Permutations II
 *
 * Created by happygirlzt on 30 Aug 2018 at 6:48:06 PM
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        backtrack(res, nums, 0);

        return res;
    }

    public static void backtrack(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            if (!res.contains(list)) {
                res.add(list);
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[start])
                    continue;
                exchange(nums, i, start);
                backtrack(res, nums, start + 1);
                exchange(nums, i, start);
            }
        }
    }

    public static void exchange(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 2 };
        System.out.println(permuteUnique(a));
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        List<Integer> list = Arrays.asList(nums);
        List<Integer> tmp = new ArrayList<>();
        helper(list, tmp, res);

        return res;
    }

    public void helper(List<Integer> list, List<Integer> tmp, List<List<Integer>> res) {
        // base case
        if (list.size() == 0) {
            if (!res.contains(tmp)) {
                res.add(tmp);
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                // choose
                tmp.add(list.get(i));
                int t = list.get(i);
                list.remove(i);

                // explore
                helper(list, tmp, res);

                // unchoose
                tmp.remove(tmp.size());
                list.add(i, t);
            }
        }
    }
}
