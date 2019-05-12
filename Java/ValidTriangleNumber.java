/**
 * Created on 12 May 2019 by happygirlzt
 *
 * LeetCode #611. Valid Triangle Number
 *
 */

class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (canConstruct(nums[i], nums[j], nums[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean canConstruct(int a, int b, int c) {
        return a + b > c && b - a < c;
    }

    // Others' smart solution
    public int triangleNumber1(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }

                count += k - j - 1;
            }
        }

        return count;
    }
}
