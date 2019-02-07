/**
 * Created on 7 Feb 2019 by happygirlzt
 *
 * LeetCode #689. Maximum Sum of 3 Non-Overlapping Subarrays
 *
 */

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxSum = 0;
        int[] sum = new int[n + 1], posLeft = new int[n], posRight = new int[n], res = new int[3];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                posLeft[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }

        posRight[n - k] = n - k;
        for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
                posRight[i] = posRight[i + 1];
            }
        }

        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (tot > maxSum) {
                maxSum = tot;
                res[0] = l; res[1] = i; res[2] = r;
            }
        }

        return res;
    }
}
