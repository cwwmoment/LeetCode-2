/**
 * Created on 14 May 2019 by happygirlzt
 *
 * LeetCode #1033. Moving Stones Until Consecutive
 *
 */

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = new int[3];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        Arrays.sort(nums);
        int[] res = new int[2];
        if (nums[1] + 1 == nums[2] && nums[0] + 1 == nums[1]) {
            return new int[]{0, 0};
        }

        if (nums[1] - nums[0] == 1 || nums[2] - nums[1] == 1 || nums[2] - nums[1] == 2 || nums[1] - nums[0] == 2) {
            res[0] = 1;
        } else {
            res[0] = 2;
        }

        res[1] = nums[2] - nums[1] - 1 + nums[1] - nums[0] - 1;
        return res;
    }

    // Elegant solution
    public int[] numMovesStones1(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a + b + c - max - min;

        int d1 = mid - min;
        int d2 = max - mid;
        if (d1 == 1 && d2 == 1) return new int[]{0, 0};
        if (d1 == 1 || d2 == 1 || d1 == 2 || d2 == 2) return new int[]{1, d1 + d2 - 2};
        return new int[]{2, d1 + d2 - 2};
    }
}
