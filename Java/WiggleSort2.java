/**
 * LeetCode #324. Wiggle Sort II
 *
 * Created on 14 Sep 2018 by happygirlzt
 */

// TODO
public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        if (nums.length == 0 || nums == null) return;

        Arrays.sort(nums);

        int len = nums.length;

        int left = 0, right = len - 1;
        int mid = left + (right - left) / 2;


    }
}
