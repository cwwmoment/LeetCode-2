/**
 * Created on 24 Dec 2018 by happygirlzt
 *
 * LeetCode #384. Shuffle an Array
 *
 */

// Fisher-Yates shuffle algorithm
class Solution {
    private int[] original;
    private int[] nums;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.nums = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
