/*
 * LeetCode #15 3Sum
 * happygirlzt
 * 2018/7/23
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort nums[]
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<List<Integer>>();


        for (int i = 0; i < nums.length; i++) {
            // Never let i refer to the same value twice to avoid duplicates
            int j = i + 1;
            int k = nums.length - 1;

            if (i != 0 && nums[i] == nums[i-1]) continue;

            while(j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    // Never let j refer to the same value twice to avoid duplicates
                    while(j < k && nums[j] == nums[j-1]) j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }

    // Updated on 7 Mar 2019
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int twoSum = 0 - nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == twoSum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    hi--;
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                } else if (nums[lo] + nums[hi] < twoSum) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return res;
    }
}
