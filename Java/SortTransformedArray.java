/**
 * Created on 4 Jan 2019 by happygirlzt
 *
 * LeetCode #360. Sort Transformed Array
 *
 */

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];

        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;

        while (i <= j) {
            if (a >= 0) {
                res[index--] = solve(nums[i], a, b, c) >= solve(nums[j], a, b, c) ? solve(nums[i++], a, b, c) : solve(nums[j--], a, b, c);
            } else {
                res[index++] = solve(nums[i], a, b, c) >= solve(nums[j], a, b, c) ? solve(nums[j--], a, b, c) : solve(nums[i++], a, b, c);
            }
        }

        return res;
    }

    private int solve(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
