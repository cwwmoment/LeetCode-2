/*
 * LeetCode # 75. Sort Colors
 * Created by happygirlzt
 * on 2018-7-26
 */

public class SortColors {

    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums == null) return;

        int n0 = 0;
        int n1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                n0 ++;
            } else if (nums[i] == 1) {
                n1 ++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j < n0) {
                nums[j] = 0;
            } else if (j < n1) {
                nums[j] = 1;
            } else {
                nums[j] = 2;
            }
        }
    }

    public static void sortColors2(int[] nums) {
        if (nums.length <= 1 || nums == null) return;

        int i = 0;  // wall between 0 and 1
        int j = i;  // the current value, wall between 1 and unchecked
        int k = nums.length - 1;  // wall between unchecked and 2

        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i++, j++);
            } else if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                swap(nums, j, k--);
            }
        }
    }

    // Updated on 4 Feb 2019
    public void sortColors3(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int i = 0;
        while (i <= hi) {
            while (i < hi && nums[i] == 2) {
                swap(nums, i, hi);
                hi--;
            }

            while (i > lo && nums[i] == 0) {
                swap(nums, i, lo);
                lo++;
            }

            i++;
        }
    }
    public static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    /* Updated on 5 Feb 2019
     * 注意点：因为i <= hi，不是 i < hi，要不然会少比较
     * edge case: [2, 0, 1]
     * swap(nums, i, hi--), i不要自增
     * edge case: [1, 2, 0]
     */
    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int i = 0;
        while (i <= hi) {
            if (nums[i] == 2) {
                swap(nums, i, hi--);
            } else if (nums[i] == 0) {
                swap(nums, i++, lo++);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
