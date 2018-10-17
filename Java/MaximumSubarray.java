/**
 *
 * Created by happygirlzt on 7 Sep 2018 at 7:10:35 PM
 *
 * LeetCode #53. Maximum Subarray
 */
public class MaximumSubarray {

    // TLE solution
    public int maxSubnumsrray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];

        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
            dp[i][len] = nums[i]; // default
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len - 1; j++) {
                if (nums[j + 1] >= 0) {
                    dp[i][j + 1] = dp[i][j] + nums[j + 1];
                } else {
                    dp[i][len] = dp[i][j];
                    break;
                }
            }
        }

        int res = dp[0][len];
        for (int k = 0; k < len; k++) {
            res = Math.max(dp[k][len], res);
        }

        return res;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int len = nums.length;
        int[] b = new int[len];
        b[0] = nums[0];
        int res = b[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] + b[i - 1] > nums[i]) {
                b[i] = nums[i] + b[i - 1];
            } else {
                b[i] = nums[i];
            }
            res = Math.max(b[i], res);
        }

        return res;
    }

    // Updated on 25 Sep 2018
    // divide and conquer
    public int maxSubArray2(int[] n) {
        int len = n.length - 1;
        int mid = (0 + len) >> 1;
        return maxSubarraySum(n, 0, len);
    }

    public int maxSubarraySum(int[] n, int low, int high) {
        // base case
        if (low == high) {
            return n[low];
        } else {
           int mid = (low + high) >> 1;
            int leftSum = maxSubarraySum(n, low, mid);
            int rightSum = maxSubarraySum(n, mid + 1, high);
            int crossSum = maxCrossingSum(n, low, mid, high);

            if (leftSum >= rightSum && leftSum >= crossSum) {
                return leftSum;
            } else if (rightSum >= leftSum && rightSum >= crossSum) {
                return rightSum;
            } else {
                return crossSum;
            }
        }
    }
    // Find n[mid] is crossing the array
    public int maxCrossingSum(int[] n, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        // Include elements on left of mid
        for (int i = mid; i >= low; i--) {
            sum += n[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        // Include elements on right of mid
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += n[j];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        // return sum of elements on left and right of mid
        return (leftSum + rightSum);
    }
}
