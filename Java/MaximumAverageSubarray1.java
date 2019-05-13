/**
 * Created on 13 May 2019 by happygirlzt
 *
 * LeetCode #643. Maximum Average Subarray I
 *
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        double sum = 0.0;
        double max = 0.0;
        boolean seen = false;
        for (int num : nums) {
            q.offer(num);
            sum += num;

            if (q.size() > k) {
                sum -= q.poll();
            }

            if (q.size() == k) {
                if (!seen) {
                    max = sum / (double) k;
                    seen = true;
                } else {
                    max = Math.max(max, sum / (double) k);
                }
            }
        }

        return max;
    }

    // Solution 1: Sliding Window, O(N)
    public double findMaxAverage1(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }

        return res / k;
    }
}
