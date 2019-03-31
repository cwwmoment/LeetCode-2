/*
 * LeetCode #16 3Sum Closest
 * happygirlzt
 * 2018/7/23
 */

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<Integer>();

        int res = 0;
        for (int i = 0; i < nums.length; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    return target;
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    set.add(nums[i] + nums[j] + nums[k]);
                    j++;
                } else {
                    set.add(nums[i] + nums[j] + nums[k]);
                    k--;
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : set) {
            map.put(i, Math.abs(target - i));
        }

        Integer min = Collections.min(map.values());

        for (Integer key : map.keySet()) {
            if (map.get(key) == min) {
                return key;
            }
        }

        return res;
    }

    // a little bit improvement
    public static int solution2(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }

                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }

        return res;
    }

    // Updated on 31 Mar 2019
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;

        for (int i = 0; i < n - 2; i++) {
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int tmpSum = getThreeSum(nums, i, lo, hi);
                if (tmpSum == target) return tmpSum;

                int tmpDiff = tmpSum - target;

                if (Math.abs(tmpDiff) < minDiff) {
                    minDiff = Math.abs(tmpSum - target);
                    closestSum = tmpSum;
                }

                if (tmpDiff > 0) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return closestSum;
    }

    private int getThreeSum(int[] nums, int i, int j, int k) {
        return nums[i] + nums[j] + nums[k];
    }
}
