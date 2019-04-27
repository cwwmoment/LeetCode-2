/**
 * Created on 27 Apr 2019 by happygirlzt
 *
 * LeetCode #368. Largest Divisible Subset
 *
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] count = new int[n];
        int[] prev = new int[n];
        Arrays.fill(count, 1);
        Arrays.fill(prev, -1);
        Arrays.sort(nums);

        int max = 0;
        int index = -1;

        // DP, treat each i as the ending index, search for the previous
        // index for the largest divisible subset.
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                    }
                }
            }

            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }

        return res;
    }
}
