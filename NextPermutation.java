/**
 * Created on 14 Sep 2018 by happygirlzt
 *
 * LeetCode #31. Next Permutation
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0 || len == 1) return;

        int tmp = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i + 1] >= nums[i]) {
                tmp = i;
            } else {
                break;
            }
        }

        if (tmp == len - 1) {
            Arrays.sort(nums);
        } else {
            int t = nums[tmp];
            nums[tmp] = nums[tmp + 1];
            nums[tmp + 1] = t;
        }
    }
}
