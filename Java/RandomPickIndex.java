/**
 * Created on 19 Jan 2019 by happygirlzt
 *
 * LeetCode #398. Random Pick Index
 *
 */

class Solution {

    private int[] a;
    private Random r;
    public Solution(int[] nums) {
        a = nums;
        r = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                if (r.nextInt(++count) == 0) {
                    res = i;
                }
            }
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
