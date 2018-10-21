/**
 * Created on 18 Oct 2018 by happygirlzt
 *
 * LeetCode #698. Partition to K Equal Sum Subsets
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int res = 0;
        for (int i : nums) {
            res += i;
        }

        if (res % k != 0) return false;

        int avg = res / k;
        boolean[] visited = new boolean[nums.length];

        return helper(nums, visited, avg, k, avg, 0);
    }

    public boolean helper(int[] nums, boolean[] visited, int avg, int k, int tmp, int index) {
        if (k == 0) return true;

        if (tmp == 0)
            return helper(nums, visited, avg, k - 1, avg, 0);

        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            if (tmp - nums[i] >= 0 && helper(nums, visited, avg, k, tmp - nums[i], index + 1)) {
                return true;
            }

            visited[i] = false;
        }

        return false;
    }
}
