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

    // Updated on 20 Feb 2019
    public int[] maxSumOfThreeSubarrays1(int[] nums, int m) {
        // Be care of all the borders
        int n = nums.length;
        int len = n - m + 1;
        int[] dp = new int[len];
        int sum = 0;
         for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
             if (i >= m) sum -= nums[i - m];
             if (i >= m - 1) dp[i - m + 1] = sum;
         }
        
        int[] left = new int[len];
        int best = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] > dp[best]) best = i;
            left[i] = best;
        }
        
        int[] right = new int[len];
        best = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] > dp[best]) best = i;
            right[i] = best;
        }
        
        int[] res = new int[3];
        Arrays.fill(res, -1);
        // Pay attention to the border check!!!
        for (int j = m; j < n - 2 * m + 1; j++) {
            if (res[0] == -1 || dp[j] + dp[left[j - m]] + dp[right[j + m]] >
               dp[res[0]] + dp[res[1]] + dp[res[2]]) {
                res[0] = left[j - m];
                res[1] = j;
                res[2] = right[j + m];
            }
        }
        
        return res;
    }
}
}
